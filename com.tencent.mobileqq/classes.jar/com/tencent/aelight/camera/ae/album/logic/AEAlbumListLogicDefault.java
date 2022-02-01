package com.tencent.aelight.camera.ae.album.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.adapter.AENewAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAlbumListFragment;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class AEAlbumListLogicDefault
  extends AEAlbumListLogicBase<AEAlbumListFragment>
  implements AEAlbumListLogic.IalbumListAdapterCallBack
{
  protected AlbumListData g;
  protected final boolean h = AEThemeUtil.b();
  
  protected AEAlbumListLogicDefault(AEAlbumListFragment paramAEAlbumListFragment)
  {
    super(paramAEAlbumListFragment);
    this.e = this;
    this.c = new AlbumListData();
    this.g = ((AlbumListData)this.c);
  }
  
  public static AEAlbumListLogic a(AEAlbumListFragment paramAEAlbumListFragment)
  {
    if ((d == null) || (d.a.get() != paramAEAlbumListFragment)) {}
    try
    {
      if ((d == null) || (d.a.get() != paramAEAlbumListFragment)) {
        d = new AEAlbumListLogicDefault(paramAEAlbumListFragment);
      }
      return d;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = e();
    Object localObject = paramViewGroup.a(paramInt);
    TextView localTextView = (TextView)paramView;
    if (((QQAlbumInfo)localObject).id.equals("qzone_album"))
    {
      localObject = paramViewGroup.c.getDrawable(2130853604);
      ((Drawable)localObject).setBounds(0, 0, paramViewGroup.d, paramViewGroup.e);
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    paramView.setBackgroundResource(2063794180);
    localTextView.setTextColor(paramViewGroup.c.getColor(2131165564));
    return paramView;
  }
  
  public String a()
  {
    return super.a();
  }
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    paramList1 = super.a(paramList1, paramList2, paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty()) && (paramInt == -1) && (e().o) && (e().p > 0L))
    {
      paramList2 = new QQAlbumInfo();
      paramList2.id = "qzone_album";
      paramList2.name = "空间相册";
      paramList2.mMediaFileCount = ((int)e().p);
      paramList1.add(0, paramList2);
    }
    return paramList1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.g.a = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.b.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    if (this.b.isShowQzoneAlbum) {
      ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.g.b, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    if (paramQQAlbumInfo.id.equals("qzone_album"))
    {
      Bundle localBundle = paramIntent.getExtras();
      localBundle.putInt("key_personal_album_enter_model", 1);
      localBundle.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      localBundle.putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      localBundle.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localBundle.putString("keyAction", "actionSelectPicture");
      localBundle.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.forwardToPersonalAlbumSelect(((AEAlbumListFragment)this.a.get()).getActivity(), localUserInfo, localBundle, 10016);
      return a(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo.id)) {
      ReportController.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.a(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo.id.equals("qzone_album")) && (paramBoolean);
  }
  
  public void b() {}
  
  protected AEAlbumListAdapter c()
  {
    return new AENewAlbumListAdapter((AEAlbumListFragment)this.a.get());
  }
  
  protected AENewAlbumListAdapter e()
  {
    return (AENewAlbumListAdapter)super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicDefault
 * JD-Core Version:    0.7.0.1
 */