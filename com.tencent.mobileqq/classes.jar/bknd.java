import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.9;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class bknd
  extends bkna<bkml>
  implements bkmv, bkmw, bkmx, xix
{
  public aimk a;
  
  protected bknd(bkml parambkml)
  {
    super(parambkml);
    this.jdField_a_of_type_Bkmx = this;
    this.jdField_a_of_type_Bkmv = this;
    this.jdField_a_of_type_Bkmw = this;
    this.a = new aimk();
    this.jdField_a_of_type_Aimk = ((aimk)this.a);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_Aimj.myUin);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aimj.currentQualityType);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aimk.e);
    paramView.putExtra("PhotoConst.editPathMap", aikk.a(this.jdField_a_of_type_Aimk.jdField_c_of_type_JavaUtilHashMap));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaUtilHashMap);
    if ((this.jdField_a_of_type_Aimj.selectedPhotoList != null) && (this.jdField_a_of_type_Aimj.selectedPhotoList.size() > 0)) {
      azmj.b(null, "CliOper", "", this.jdField_a_of_type_Aimj.myUin, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aimj.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Aimj.maxSelectNum;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Aimj.a()) || (this.jdField_a_of_type_Aimk.isSupportVideoCheckbox)) {
        break label82;
      }
      str1 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695259, new Object[] { Integer.valueOf(i) });
    }
    label82:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (!this.jdField_a_of_type_Aimk.isSupportVideoCheckbox);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if (this.jdField_a_of_type_Aimj.a()) {
      return ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695260, new Object[] { Integer.valueOf(i) });
    }
    return ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695258, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Aimj.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (this.jdField_a_of_type_Aimj.a()) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aimj.albumId)) && (this.jdField_a_of_type_Aimj.albumId.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(xir.a().b());
        bddw.a("PEAK", "getAlbumMedias");
        if (localObject1 != null) {
          break label214;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, "photoList is null");
        }
        localObject2 = null;
      }
    }
    label214:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = bdar.getAlbumMedias(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aimj.albumId, this.jdField_a_of_type_Aimj.albumName, i, this.jdField_a_of_type_Aimk.filter, 0, 0, true, null, false, this.jdField_a_of_type_Aimk.filterVideoDurationLimit, 1);
          break;
          localObject1 = bdar.getAlbumMedias(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aimj.albumId, this.jdField_a_of_type_Aimj.albumName, i, this.jdField_a_of_type_Aimk.filter, this.jdField_a_of_type_Aimk.filterVideoDurationLimit);
          break;
          localObject2 = localObject1;
        } while (this.jdField_a_of_type_Aimj.selectedPhotoList == null);
        localObject2 = localObject1;
      } while (this.jdField_a_of_type_Aimj.selectedPhotoList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_Aimj.selectedPhotoList.size());
    Object localObject2 = (String)this.jdField_a_of_type_Aimj.selectedPhotoList.get(i);
    int j;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break;
      j = i;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.jdField_a_of_type_Aimj.selectedPhotoList.remove(i);
          i -= 1;
          j = i;
          if (this.jdField_a_of_type_Aimj.needMediaInfo)
          {
            j = i;
            if (this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap != null)
            {
              j = i;
              if (this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.containsKey(localObject2))
              {
                this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.remove(localObject2);
                j = i;
              }
            }
          }
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    RecyclerView localRecyclerView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    bkmg localbkmg = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int i = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localbkmg.a(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (bkmi)localRecyclerView.getChildViewHolder(localRecyclerView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2));
          if ((localObject != null) && (((bkmi)localObject).a != null)) {
            ((bkmi)localObject).a.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      xir.a().b(localArrayList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap);
    }
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(true);
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.a(paramIntent);
    this.jdField_a_of_type_Aimk.m = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    aikk.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, false, this.jdField_a_of_type_Aimk.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.jdField_a_of_type_Aimj.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Aimk.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_Aimk.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.jdField_a_of_type_Aimj.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.jdField_a_of_type_Aimk.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Aimk.f = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Aimk.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.jdField_a_of_type_Aimk.h = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Aimk.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Aimj.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_Aimk.isSingleMode = false;
    }
    this.jdField_a_of_type_Aimk.i = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Aimk.j = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.jdField_a_of_type_Aimk.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_Aimk.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Aimj.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Aimk.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.jdField_a_of_type_Aimj.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.jdField_a_of_type_Aimk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.jdField_a_of_type_Aimk.j)
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
        if (localPresendPicMgr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
          }
          localPresendPicMgr.a(1004);
        }
        PhotoUtils.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.currentQualityType, true);
      }
      if (!this.jdField_a_of_type_Aimk.e) {
        this.jdField_a_of_type_Aimk.e = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.jdField_a_of_type_Aimk.e)
      {
        this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.jdField_a_of_type_Aimk.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.jdField_a_of_type_Aimk.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.jdField_a_of_type_Aimj.isShowQzoneAlbum)
      {
        paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), ayxl.class);
        paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(bkml.jdField_a_of_type_Bkmo);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
      }
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
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Aimk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
        if (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
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
      if ((ayyu.b != 0L) && (System.currentTimeMillis() - ayyu.b < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + ayyu.b);
        }
        if ((!bdee.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719738);
        paramIntent = new AEPhotoListLogicDefault.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (bevd.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 4, new bkne(this, paramIntent))) {
          bdcd.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 232, null, (String)localObject1, new bknf(this, paramIntent), new bkng(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aimj.currentQualityType, false);
      }
      for (;;)
      {
        azmj.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Aimj.currentQualityType, this.jdField_a_of_type_Aimk.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < aimj.getInstance().maxSelectNum) {
        break label165;
      }
      QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), String.format(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695258), new Object[] { Integer.valueOf(aimj.getInstance().maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      return;
      label165:
      aimj.getInstance().selectedPhotoList.add(str);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
    }
  }
  
  public void a(View paramView)
  {
    bdar.clearSelectItemInfo();
    bdar.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_Aimj.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_Aimj.selectedPhotoList.size();; i = 0)
    {
      aild.b(paramView, i);
      if (this.jdField_a_of_type_Aimk.i) {
        break;
      }
      if (this.jdField_a_of_type_Aimj.a()) {
        xir.a().a(xir.a().c());
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bdar.anim(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
    }
    paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    bdar.anim(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_Aimj.selectedPhotoList;
    if (this.jdField_a_of_type_Aimk.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    Object localObject1;
    do
    {
      long l;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
        }
        localLocalMediaInfo = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.a(paramInt);
        i = localLocalMediaInfo.selectStatus;
        if ((i == 1) || (paramView.size() < this.jdField_a_of_type_Aimj.maxSelectNum)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Aimk.lastTimeShowToast < 1000L);
      QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
      paramCheckBox.setChecked(false);
      this.jdField_a_of_type_Aimk.lastTimeShowToast = l;
      k();
      return;
      if ((this.jdField_a_of_type_Aimk.jdField_a_of_type_Int == 9501) && (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        localObject1 = paramView.iterator();
        for (l = 0L; ((Iterator)localObject1).hasNext(); l = bdcs.a((String)((Iterator)localObject1).next()) + l) {}
        if (bdcs.a(localLocalMediaInfo.path) + l > 52428800L)
        {
          QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "选择图片总大小不能超过50M", 0).b(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
          paramCheckBox.setChecked(false);
          return;
        }
      }
      if ((((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (bdcs.a(localLocalMediaInfo.path) > 3145728L))
      {
        QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "图片文件过大", 0).b(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        paramCheckBox.setChecked(false);
        return;
      }
    } while ((this.jdField_a_of_type_Aimj.a()) && (!bnbf.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), localLocalMediaInfo)));
    label473:
    boolean bool1;
    label492:
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label1135;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      if (!bool1) {
        break label1141;
      }
      localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      aimk localaimk;
      if ((this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localaimk = this.jdField_a_of_type_Aimk;
        localaimk.videoSelectedCnt += 1;
        if (this.jdField_a_of_type_Aimk.videoSelectedCnt == 1) {
          this.jdField_a_of_type_Aimk.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localaimk = this.jdField_a_of_type_Aimk;
        localaimk.gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_Aimj.selectedIndex.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_Aimj.needMediaInfo) {
        this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).a(paramCheckBox, 1052, ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.jdField_a_of_type_Aimj.albumId);
      if (paramView != null) {
        break label1393;
      }
      paramView = new LinkedHashMap();
      bdar.sSelectItemPosMap.put(this.jdField_a_of_type_Aimj.albumId, paramView);
    }
    label907:
    label1135:
    label1393:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = bdar.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Aimj.albumId, this.jdField_a_of_type_Aimj.albumName));
      }
      if (this.jdField_a_of_type_Bkmy != null) {
        this.jdField_a_of_type_Bkmy.a(bool1, localLocalMediaInfo);
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (bkml)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.b(bool1);
        d();
        if (!this.jdField_a_of_type_Aimj.a()) {
          break;
        }
        if (xir.a().a().isEmpty())
        {
          i = ((GridLayoutManager)((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
          paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i);
          if ((paramView != null) && (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - paramView.getY() < ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int)) {
            ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(xir.jdField_a_of_type_Int, 500);
          }
        }
        xir.a().b(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap);
        return;
        i = 1;
        break label473;
        bool1 = false;
        break label492;
        label1141:
        localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Aimk.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Aimk.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject2).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_Aimj.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Aimj.needMediaInfo) {
          this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).b(paramCheckBox, 1013);
        }
        aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bdar.sSelectItemPosMap.get(this.jdField_a_of_type_Aimj.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bdar.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label907;
        }
        paramView.remove(paramCheckBox);
        break label907;
      }
    }
  }
  
  public void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aimj.selectedPhotoList.size() > 0)
    {
      paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aimj.selectedPhotoList);
      azmj.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), (String)this.jdField_a_of_type_Aimj.selectedPhotoList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      d(paramView);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (bdar.a(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.jdField_a_of_type_Int, this.jdField_a_of_type_Aimj.allMediaInfoHashMap, this.jdField_a_of_type_Aimk.k, this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695271), 0).b(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298914));
        this.jdField_a_of_type_Aimj.currentQualityType = 0;
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Aimk.jdField_d_of_type_Boolean) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (bdar.a(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.videoSizeLimit, this.jdField_a_of_type_Aimj.allMediaInfoHashMap, this.jdField_a_of_type_Aimk.k, this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131720121), 0).b(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298914));
        bdar.c();
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_a_of_type_Aimj.currentQualityType = 2;
      bdar.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap, this.jdField_a_of_type_Aimk.k, ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap);
      continue;
      this.jdField_a_of_type_Aimj.currentQualityType = 0;
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void a(bkmi parambkmi, LocalMediaInfo paramLocalMediaInfo)
  {
    if (aikk.a(paramLocalMediaInfo.path, this.jdField_a_of_type_Aimk.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        parambkmi.e.setImageDrawable(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getDrawable(2130839177));
      }
      for (;;)
      {
        parambkmi.e.setVisibility(0);
        return;
        parambkmi.e.setImageResource(2130839177);
      }
    }
    parambkmi.e.setVisibility(8);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg;
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((bkmg)localObject1).a();
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
        paramSlideItemInfo = ((bkmg)localObject1).a(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Aimk.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Aimk.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject2).gifSelectedCount -= 1;
        }
        this.jdField_a_of_type_Aimj.selectedPhotoList.remove(localObject1);
        this.jdField_a_of_type_Aimj.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.jdField_a_of_type_Aimj.needMediaInfo) {
          this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.remove(localObject1);
        }
        aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)bdar.sSelectItemPosMap.get(this.jdField_a_of_type_Aimj.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = bdar.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Bkmy != null) {
          this.jdField_a_of_type_Bkmy.a(false, paramSlideItemInfo);
        }
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(i, false);
        d();
        xir.a().b(localArrayList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap);
      }
      label402:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Aimj.needMediaInfo) {
        this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)bdar.sSelectItemPosMap.get(this.jdField_a_of_type_Aimj.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = bdar.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).f();
      d();
      xir.a().b(localArrayList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap);
      return;
      label562:
      i = -1;
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    aikk.a(paramList, null, this.jdField_a_of_type_Aimk.jdField_c_of_type_JavaUtilHashMap);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    bdar.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        azmj.b(null, "CliOper", "", this.jdField_a_of_type_Aimj.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
        break label365;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aimj.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aimj.albumName);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aimj.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aimj.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaUtilHashMap);
      aimk.sPhotoListFirstPos = ((GridLayoutManager)((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      bdar.anim(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Aimk.currentPhotoPath);
      break;
      label365:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
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
    if (this.jdField_a_of_type_Aimk.firstResume)
    {
      this.jdField_a_of_type_Aimk.firstResume = false;
      if (this.jdField_a_of_type_Aimk.photoListStartPos != -1) {
        break label385;
      }
      i = aimk.sPhotoListFirstPos;
      if (i != -1) {
        break label414;
      }
      Object localObject = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.jdField_a_of_type_Aimj.albumId);
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
        if (this.jdField_a_of_type_Aimk.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          k = 0;
          label157:
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label396;
            }
            i = k;
          }
        }
      }
      localObject = this.jdField_a_of_type_Aimj.selectedPhotoList;
      j = i;
      if (i == -1)
      {
        j = i;
        if (this.jdField_a_of_type_Aimj.albumId.equals("$RecentAlbumId"))
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
                break label405;
              }
              j = k;
            }
          }
        }
      }
      label295:
      i = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.getItemCount();
      if (i != 0) {
        break label423;
      }
      label316:
      if (!this.jdField_a_of_type_Aimj.a()) {
        break label440;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aimj.a())
      {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap);
        xir.a().b(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap);
      }
      return true;
      label385:
      i = this.jdField_a_of_type_Aimk.photoListStartPos;
      break;
      label396:
      k += 1;
      break label157;
      label405:
      k += 1;
      break label261;
      label414:
      aimk.sPhotoListFirstPos = -1;
      j = i;
      break label295;
      label423:
      if ((j > i - 1) || (j >= 0)) {
        break label316;
      }
      break label316;
      label440:
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicDefault.9(this));
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aimj.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_Aimj.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.jdField_a_of_type_Aimj.myUin);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!bdal.a()) {
      QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719535), 0).a();
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.a(paramInt);
    } while (localObject1 == null);
    paramView = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (((LocalMediaInfo)localObject1).fileSize > this.jdField_a_of_type_Aimj.videoSizeLimit)
    {
      paramView = bdcd.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131694951, new bdco());
      paramView.show();
      return;
    }
    Object localObject2 = bdar.sSelectItemAlbum;
    Object localObject3;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path))
    {
      localObject3 = new Pair(this.jdField_a_of_type_Aimj.albumId, this.jdField_a_of_type_Aimj.albumName);
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject3);
    }
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(((LocalMediaInfo)localObject1).path);
    if (!this.jdField_a_of_type_Aimk.jdField_b_of_type_Boolean)
    {
      paramView.putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", ((LocalMediaInfo)localObject1).fileSize);
      paramView.putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
      paramView.putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
      paramView.putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
      paramView.putExtra("media_info", (Parcelable)localObject1);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(((LocalMediaInfo)localObject1).path);
      PhotoUtils.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Aimk.isSingleMode)
    {
      localObject1 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      ((Intent)localObject1).putExtra("ALBUM_NAME", this.jdField_a_of_type_Aimj.albumName);
      ((Intent)localObject1).putExtra("ALBUM_ID", this.jdField_a_of_type_Aimj.albumId);
      localObject2 = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.a(paramInt);
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject2).position);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aimj.selectedPhotoList);
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aimj.selectedIndex);
      ((Intent)localObject1).putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aimj.currentQualityType);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aimk.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaLangString);
      aimk.sPhotoListFirstPos = ((GridLayoutManager)((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      localObject3 = this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaUtilHashMap);
      ((Intent)localObject1).setClass(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.jdField_a_of_type_Aimj.selectedPhotoList != null) && (this.jdField_a_of_type_Aimj.selectedPhotoList.size() > 0)) {
        azmj.b(null, "CliOper", "", this.jdField_a_of_type_Aimj.myUin, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aimj.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aimj.a()) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        bdar.anim(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
        return;
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity((Intent)localObject1);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      }
    }
    localObject2 = new Intent(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras(paramView);
    ((Intent)localObject2).putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
    ((Intent)localObject2).putExtra("file_send_size", ((LocalMediaInfo)localObject1).fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
    ((Intent)localObject2).putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
    ((Intent)localObject2).putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Aimk.jdField_d_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_Aimk.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    if (this.jdField_a_of_type_Aimk.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aimj.selectedPhotoList);
    }
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject2, 17);
  }
  
  public View c()
  {
    return super.c();
  }
  
  public void c()
  {
    Object localObject = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView;
    int i;
    if ((this.jdField_a_of_type_Aimk.isSingleMode) || (this.jdField_a_of_type_Aimk.showMediaType == 2) || (this.jdField_a_of_type_Aimj.a()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      if (!this.jdField_a_of_type_Aimk.e) {
        break label347;
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aimk.jdField_c_of_type_Boolean) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      }
      d();
      if (this.jdField_a_of_type_Aimj.a())
      {
        this.jdField_a_of_type_Aimk.jdField_a_of_type_Xiv = new xiv(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this);
        xir.a().a(this.jdField_a_of_type_Aimk.jdField_a_of_type_Xiv);
        xir.a().a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
        l();
        if (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (xiy)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((xiy)localObject).a();
          }
          ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label347:
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    if (!this.jdField_a_of_type_Aimj.selectedPhotoList.isEmpty()) {
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Aimj.selectedPhotoList.get(this.jdField_a_of_type_Aimj.selectedPhotoList.size() - 1));
    }
    bdar.a();
    if (this.jdField_a_of_type_Aimj.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Aimj.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bdcs.a((String)paramView.next()) + l) {}
      if (arni.a())
      {
        armv.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131692752, 2131692757, new bknh(this));
        return;
      }
    }
    i();
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!bdal.a())
    {
      QQToast.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719535), 0).a();
      return;
    }
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).g();
  }
  
  public void c_(String paramString)
  {
    Intent localIntent = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    HashMap localHashMap = this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aimj.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aimj.albumId);
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
    if ((i > 0) && (i < ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.getItemCount()))
    {
      localObject = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg.a(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    aimk.sPhotoListFirstPos = ((GridLayoutManager)((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    c(localIntent);
    bdar.anim(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  protected void d()
  {
    super.d();
    ArrayList localArrayList = this.jdField_a_of_type_Aimj.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_a_of_type_Aimk.e) {
        break label422;
      }
      if ((localArrayList.size() != 1) || ((this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Aimj.jdField_a_of_type_JavaUtilHashMap.size() > 0)) || (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localArrayList.get(0)) != 0)) {
        break label402;
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Aimk.jdField_c_of_type_Boolean)
      {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0)
        {
          ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
          ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setEnabled(true);
        }
      }
      j();
      if (!this.jdField_a_of_type_Aimk.jdField_d_of_type_Boolean) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label402:
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      label422:
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void d(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aimk.l)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void e()
  {
    super.e();
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Aimk.requestCode == 100016) {
      if (!((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      }
    }
    do
    {
      return;
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.jdField_a_of_type_Aimk.requestCode = 0;
      if (((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton != null) {
        ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!this.jdField_a_of_type_Aimj.a());
    xir.a().c();
    xir.a().a(this.jdField_a_of_type_Aimk.jdField_a_of_type_Xiv);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aimj.isShowQzoneAlbum) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(bkml.jdField_a_of_type_Bkmo);
    }
    if (this.jdField_a_of_type_Aimj.a()) {
      xir.a().f();
    }
    super.f();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Aimj.albumId.equals("$RecentAlbumId")) {
      azmz.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Aimk.e) || ((TextUtils.isEmpty(this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Aimk.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.jdField_a_of_type_Aimj.albumName.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Aimj.albumName.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Aimj.albumName.contains("Camera")) || (this.jdField_a_of_type_Aimj.albumName.contains("camera"))) {
        azmz.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        azmz.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.jdField_a_of_type_Aimj.selectedPhotoList != null)
    {
      aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_Aimj.selectedPhotoList.size());
      aild.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_Aimj.selectedPhotoList.size(), this.jdField_a_of_type_Aimj.currentQualityType);
    }
    Intent localIntent = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_Aimj.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      azmj.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.jdField_a_of_type_Aimj.needMediaInfo) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap);
      }
      if (this.jdField_a_of_type_Aimj.selectedPhotoList != null) {
        ajnh.a(this.jdField_a_of_type_Aimj.selectedPhotoList);
      }
      d(localIntent);
      a(localIntent, false, this.jdField_a_of_type_Aimj.selectedPhotoList);
      return;
      if ((localPresendPicMgr != null) && (!this.jdField_a_of_type_Aimk.l) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  public void j()
  {
    aimj localaimj = this.jdField_a_of_type_Aimj;
    switch (localaimj.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    bdar.a(((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView, localaimj.selectedPhotoList, localaimj.allMediaInfoHashMap, this.jdField_a_of_type_Aimk.k, ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aimk.jdField_a_of_type_JavaUtilHashMap, localaimj.selectedMediaInfoHashMap);
    ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Aimk.l) {
      azmj.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  void l()
  {
    Object localObject = xir.a().a();
    if (this.jdField_a_of_type_Aimk.m) {
      xir.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.jdField_a_of_type_Aimj.selectedPhotoList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Aimj.selectedPhotoList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Aimj.selectedIndex.contains(localSlideItemInfo.a.position)) {
          this.jdField_a_of_type_Aimj.selectedIndex.add(localSlideItemInfo.a.position);
        }
        this.jdField_a_of_type_Aimj.selectedMediaInfoHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.a);
      }
    }
    if (this.jdField_a_of_type_Aimj.selectedPhotoList.size() > 0) {
      xir.a().a(this.jdField_a_of_type_Aimj.selectedPhotoList, this.jdField_a_of_type_Aimj.allMediaInfoHashMap, false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((bkml)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkmg;
      } while ((localObject == null) || (((bkmg)localObject).a == null));
      localObject = (LocalMediaInfo)((bkmg)localObject).a.get(paramInt);
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
 * Qualified Name:     bknd
 * JD-Core Version:    0.7.0.1
 */