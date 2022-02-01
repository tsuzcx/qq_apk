import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.2;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.8;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;

public class bnaa
  extends bmzr<bmza>
  implements bmzi, bmzj, bmzk, zaf
{
  public akmi a;
  private List<bnah> a;
  
  public bnaa(bmza parambmza)
  {
    super(parambmza);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bmzk = this;
    this.jdField_a_of_type_Bmzi = this;
    this.jdField_a_of_type_Bmzj = this;
    this.a = new akmi();
    this.jdField_a_of_type_Akmi = ((akmi)this.a);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new bnah(this, paramInt));
    }
  }
  
  private void k()
  {
    if (!bmwb.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new bnah(this, -1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bnab(this));
      return;
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(AIManager.installDetector(PTFaceDetector.class), -2);
      a(FeatureManager.Features.PAG.init(), -6);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      str1 = str2;
      if (this.jdField_a_of_type_Akmi.isSupportVideoCheckbox)
      {
        str1 = str2;
        if (paramLocalMediaInfo != null)
        {
          str1 = str2;
          if ("video".equals(paramLocalMediaInfo[0])) {
            str1 = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694632, new Object[] { Integer.valueOf(i) });
          }
        }
      }
    }
    return str1;
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList = AlbumUtil.getAlbumMedias(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_Akmi.filterVideoDurationLimit);
    bhfd.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i))) {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    RecyclerView localRecyclerView = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    bmyv localbmyv = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int i = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localbmyv.a(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (bmyx)localRecyclerView.getChildViewHolder(localRecyclerView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2));
          if ((localObject != null) && (((bmyx)localObject).a != null)) {
            ((bmyx)localObject).a.setCheckedNumber(j + 1 + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
          }
        }
        paramInt1 += 1;
      }
      yzz.a().b(localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
    }
    ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).d(true);
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.a(paramIntent);
    k();
    l();
    this.jdField_a_of_type_Akmi.k = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    akkq.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, false, this.jdField_a_of_type_Akmi.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Akmi.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_Akmi.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.jdField_a_of_type_Akmi.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Akmi.f = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Akmi.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.jdField_a_of_type_Akmi.h = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Akmi.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_Akmi.i = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Akmi.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_Akmi.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Akmi.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.jdField_a_of_type_Akmi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (!this.jdField_a_of_type_Akmi.e) {
        this.jdField_a_of_type_Akmi.e = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.jdField_a_of_type_Akmi.e)
      {
        this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.jdField_a_of_type_Akmi.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "submit", localException);
        }
      }
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.getTypeforReportSpcialDiscuss(this.jdField_a_of_type_Akmi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((bcwz.b != 0L) && (System.currentTimeMillis() - bcwz.b < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + bcwz.b);
        }
        if ((!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718496);
        paramIntent = new AEPhotoListLogicDefault.2(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (bixr.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 4, new bnac(this, paramIntent))) {
          bhdj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 232, null, (String)localObject1, new bnad(this, paramIntent), new bnae(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.sendPhoto(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, false);
      }
      for (;;)
      {
        bdla.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.sendPhoto(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType, this.jdField_a_of_type_Akmi.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) {
        break label167;
      }
      QQToast.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), String.format(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131694632), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      return;
      label167:
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(str);
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).k();
    }
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.clearCache();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();; i = 0)
    {
      aklj.b(paramView, i);
      if (this.jdField_a_of_type_Akmi.i) {
        break;
      }
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
    }
    paramView = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      bnrh.d("AEPhotoListLogicDefault", "onTitleBtnCancelClick---className is null, return");
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    AlbumUtil.anim(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_Akmi.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      }
      localLocalMediaInfo = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(paramInt);
      i = localLocalMediaInfo.selectStatus;
      if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Akmi.lastTimeShowToast < 1000L);
    QQToast.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
    paramCheckBox.setChecked(false);
    this.jdField_a_of_type_Akmi.lastTimeShowToast = l;
    return;
    if ((this.jdField_a_of_type_Akmi.jdField_a_of_type_Int == 9501) && (((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      for (l = 0L; paramView.hasNext(); l = FileUtils.getFileSizes((String)paramView.next()) + l) {}
      if (FileUtils.getFileSizes(localLocalMediaInfo.path) + l > 52428800L)
      {
        QQToast.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "选择图片总大小不能超过50M", 0).b(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        paramCheckBox.setChecked(false);
        return;
      }
    }
    if ((((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (FileUtils.getFileSizes(localLocalMediaInfo.path) > 3145728L))
    {
      QQToast.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "图片文件过大", 0).b(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      paramCheckBox.setChecked(false);
      return;
    }
    boolean bool1;
    label472:
    Object localObject;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label963;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      paramView = PresendPicMgr.a();
      if (!bool1) {
        break label969;
      }
      localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      akmi localakmi;
      if ((this.jdField_a_of_type_Akmi.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localakmi = this.jdField_a_of_type_Akmi;
        localakmi.videoSelectedCnt += 1;
        if (this.jdField_a_of_type_Akmi.videoSelectedCnt == 1) {
          this.jdField_a_of_type_Akmi.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localakmi = this.jdField_a_of_type_Akmi;
        localakmi.gifSelectedCount += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramCheckBox);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((paramView != null) && (localObject != null) && (localObject[0] != null) && (!"video".equals(localObject[0]))) {
        paramView.a(paramCheckBox, 1052, ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      if (paramView != null) {
        break label1225;
      }
      paramView = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
    }
    label963:
    label1225:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName));
      }
      label890:
      if (this.jdField_a_of_type_Bmzl != null) {
        this.jdField_a_of_type_Bmzl.a(bool1, localLocalMediaInfo);
      }
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (bmza)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.d(bool1);
        e();
        return;
        i = 1;
        break;
        bool1 = false;
        break label472;
        label969:
        localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Akmi.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.jdField_a_of_type_Akmi;
          ((akmi)localObject).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Akmi.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Akmi.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.jdField_a_of_type_Akmi;
          ((akmi)localObject).gifSelectedCount -= 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(paramCheckBox);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (paramView != null) {
          paramView.b(paramCheckBox, 1013);
        }
        aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = AlbumUtil.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label890;
        }
        paramView.remove(paramCheckBox);
        break label890;
      }
    }
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  protected void a(bmyx parambmyx, LocalMediaInfo paramLocalMediaInfo)
  {
    if (akkq.a(paramLocalMediaInfo.path, this.jdField_a_of_type_Akmi.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        parambmyx.d.setImageDrawable(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getDrawable(2130839417));
      }
      for (;;)
      {
        parambmyx.d.setVisibility(0);
        return;
        parambmyx.d.setImageResource(2130839417);
      }
    }
    parambmyx.d.setVisibility(8);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((bmyv)localObject1).a();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label562;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label402;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((bmyv)localObject1).a(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Akmi.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Akmi;
          ((akmi)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Akmi.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Akmi.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Akmi;
          ((akmi)localObject2).gifSelectedCount -= 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(localObject1);
        }
        aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = AlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Bmzl != null) {
          this.jdField_a_of_type_Bmzl.a(false, paramSlideItemInfo);
        }
        ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(i, false);
        e();
        yzz.a().b(localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      }
      label402:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).j();
      e();
      yzz.a().b(localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      return;
      label562:
      i = -1;
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int j = localArrayList.size();
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i));
      i += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i = localArrayList.indexOf(paramString);
    if ((i > 0) && (i < ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.getItemCount()))
    {
      localObject = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    akmi.sPhotoListFirstPos = ((GridLayoutManager)((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    c(localIntent);
    AlbumUtil.anim(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    akkq.a(paramList, 0, null, this.jdField_a_of_type_Akmi.jdField_c_of_type_JavaUtilHashMap);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    AlbumUtil.clearCache();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        bdla.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaUtilHashMap);
      akmi.sPhotoListFirstPos = ((GridLayoutManager)((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      AlbumUtil.anim(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Akmi.currentPhotoPath);
    }
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    int m = 0;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {}
    while (!super.a(paramList)) {
      return false;
    }
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_Akmi.firstResume)
    {
      this.jdField_a_of_type_Akmi.firstResume = false;
      if (this.jdField_a_of_type_Akmi.photoListStartPos != -1) {
        break label343;
      }
      i = akmi.sPhotoListFirstPos;
      if (i != -1) {
        break label372;
      }
      Object localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      j = i;
      if (localObject != null)
      {
        k = ((LinkedHashMap)localObject).size();
        j = i;
        if (k > 0) {
          j = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(k - 1)])).intValue();
        }
      }
      i = j;
      if (j == -1)
      {
        i = j;
        if (this.jdField_a_of_type_Akmi.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          k = 0;
          label157:
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label354;
            }
            i = k;
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
      j = i;
      if (i == -1)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId"))
        {
          j = i;
          if (!((ArrayList)localObject).isEmpty())
          {
            int n = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = m;
            label261:
            j = i;
            if (k < n)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label363;
              }
              j = k;
            }
          }
        }
      }
      label295:
      i = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.getItemCount();
      if (i != 0) {
        break label381;
      }
    }
    for (;;)
    {
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicDefault.8(this));
      return true;
      label343:
      i = this.jdField_a_of_type_Akmi.photoListStartPos;
      break;
      label354:
      k += 1;
      break label157;
      label363:
      k += 1;
      break label261;
      label372:
      akmi.sPhotoListFirstPos = -1;
      j = i;
      break label295;
      label381:
      if ((j > i - 1) || (j >= 0)) {}
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum);
    paramIntent.putExtra("peak.myUin", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  public View c()
  {
    return super.c();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty()) {
      ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() - 1));
    }
    AlbumUtil.clearCache();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = FileUtils.getFileSizes((String)paramView.next()) + l) {}
      if (auea.a())
      {
        audn.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131692476, 2131692481, new bnaf(this));
        return;
      }
    }
    j();
  }
  
  public void d()
  {
    e();
    super.d();
  }
  
  protected void e()
  {
    super.e();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    if ((localArrayList.size() <= 0) || (QLog.isColorLevel())) {
      QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
    }
  }
  
  public void f()
  {
    super.f();
    aqrl.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Akmi.requestCode == 100016)
    {
      if (!((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      }
    }
    else {
      return;
    }
    ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
    this.jdField_a_of_type_Akmi.requestCode = 0;
  }
  
  public void g()
  {
    super.g();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      StatisticCollector.getInstance(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    for (;;)
    {
      PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Akmi.e) || ((TextUtils.isEmpty(this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("Camera")) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName.contains("camera"))) {
        StatisticCollector.getInstance(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        StatisticCollector.getInstance(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)
    {
      aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
      aklj.a(((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType);
    }
    Intent localIntent = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      alrr.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    a(localIntent, false, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((bmza)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv;
      } while ((localObject == null) || (((bmyv)localObject).a == null));
      localObject = (LocalMediaInfo)((bmyv)localObject).a.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnaa
 * JD-Core Version:    0.7.0.1
 */