import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bkml
  extends bkme
{
  public static bkmo a;
  public Handler a;
  public CheckBox a;
  public Button c;
  public TextView c;
  public TextView d;
  View e;
  public TextView e;
  TextView f;
  
  static
  {
    jdField_a_of_type_Bkmo = new bkmo();
  }
  
  public bkml()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bkmn(this);
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return bdar.getMediaType(a(paramString));
  }
  
  protected Dialog a()
  {
    Dialog localDialog = new Dialog(getActivity(), 2131755801);
    localDialog.setContentView(2131559438);
    return localDialog;
  }
  
  public bklz a()
  {
    return new bkmk();
  }
  
  protected bkmu a()
  {
    return bkmz.a(this);
  }
  
  public LocalMediaInfo a(String paramString)
  {
    aimj localaimj = this.jdField_a_of_type_Bkmu.a;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localaimj.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localaimj.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localaimj.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localaimj.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bnnu localbnnu = new bnnu();
        bnnt.a(paramString, localbnnu);
        localLocalMediaInfo.mediaWidth = localbnnu.a[0];
        localLocalMediaInfo.mediaHeight = localbnnu.a[1];
        localLocalMediaInfo.rotation = localbnnu.a[2];
        if (localaimj.allMediaInfoHashMap != null)
        {
          paramString = (LocalMediaInfo)localaimj.allMediaInfoHashMap.get(paramString);
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
  
  public String a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      Object localObject = paramString;
      if (localFile.exists())
      {
        localObject = localFile.getName();
        String str = aljq.bk + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(aljq.bk);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = bdcs.b(paramString, str);
          }
          QLog.d("PhotoListActivity", 2, new Object[] { "saveToDCIM rename to :", str });
          localObject = paramString;
          if (bool1) {
            localObject = str;
          }
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PhotoListActivity", 2, "saveToDCIM :", localThrowable);
    }
    return paramString;
  }
  
  protected void a(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375981);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131367310);
    this.f = ((TextView)paramView.findViewById(2131379325));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369974));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131373917));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373923));
    this.d = ((TextView)paramView.findViewById(2131373918));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368077));
    super.a(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bkmm(this));
  }
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.jdField_a_of_type_Bkmu.a.allMediaInfoHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.jdField_a_of_type_Bkmu.a.allMediaInfoHashMap.get(str));
        }
      }
    }
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
  
  public void g()
  {
    if (lmm.b(BaseApplicationImpl.getContext())) {}
    label27:
    do
    {
      return;
      Intent localIntent = new Intent();
      Object localObject = null;
      try
      {
        File localFile = a();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        break label27;
      }
    } while (localObject == null);
    FileProvider7Helper.setSystemCapture(getActivity(), localObject, localIntent);
    startActivityForResult(localIntent, 16);
  }
  
  public void h()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && ("$RecentAlbumId".equals(this.jdField_a_of_type_Bkmu.a.albumId))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo) && ("$VideoAlbumId".equals(this.jdField_a_of_type_Bkmu.a.albumId)))) {
      e();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Bkmu.a(paramView, new Bundle(), 2, null);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    abqw.a().c();
    if (!CheckPermission.isHasStoragePermission(getActivity().getApplicationContext())) {
      CheckPermission.requestStorePermission(getActivity(), null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkml
 * JD-Core Version:    0.7.0.1
 */