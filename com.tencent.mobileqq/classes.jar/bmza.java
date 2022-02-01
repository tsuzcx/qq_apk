import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;

public class bmza
  extends bmyq
{
  public Handler a;
  
  public bmza()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bmzc(this);
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return AlbumUtil.getMediaType(a(paramString));
  }
  
  protected Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755829);
    localReportDialog.setContentView(2131559607);
    return localReportDialog;
  }
  
  public bmyl a()
  {
    return new bmyz();
  }
  
  protected bmzh a()
  {
    return new bmzm(this);
  }
  
  public LocalMediaInfo a(String paramString)
  {
    PhotoCommonBaseData localPhotoCommonBaseData = this.jdField_a_of_type_Bmzh.a;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bptj localbptj = new bptj();
        bpti.a(paramString, localbptj);
        localLocalMediaInfo.mediaWidth = localbptj.a[0];
        localLocalMediaInfo.mediaHeight = localbptj.a[1];
        localLocalMediaInfo.rotation = localbptj.a[2];
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null)
        {
          paramString = (LocalMediaInfo)localPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  public Class a()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bmzb(this));
  }
  
  public void b(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(getActivity(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PhotoListActivity", 2, "scanMediaFile :", paramString);
    }
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && ("$RecentAlbumId".equals(this.jdField_a_of_type_Bmzh.a.albumId))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && ("$VideoAlbumId".equals(this.jdField_a_of_type_Bmzh.a.albumId)))) {
      i();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bmzh.a(paramView, new Bundle(), 2, null);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!CheckPermission.isHasStoragePermission(getActivity().getApplicationContext())) {
      CheckPermission.requestStorePermission(getActivity(), null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    aqrl.a(BaseApplicationImpl.getContext(), 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmza
 * JD-Core Version:    0.7.0.1
 */