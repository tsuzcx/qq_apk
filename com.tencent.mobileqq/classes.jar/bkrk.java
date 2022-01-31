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

public class bkrk
  extends bkrh<bkqs>
  implements bkrc, bkrd, bkre, xng
{
  public aiqz a;
  
  protected bkrk(bkqs parambkqs)
  {
    super(parambkqs);
    this.jdField_a_of_type_Bkre = this;
    this.jdField_a_of_type_Bkrc = this;
    this.jdField_a_of_type_Bkrd = this;
    this.a = new aiqz();
    this.jdField_a_of_type_Aiqz = ((aiqz)this.a);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_Aiqy.myUin);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aiqy.currentQualityType);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aiqz.e);
    paramView.putExtra("PhotoConst.editPathMap", aioz.a(this.jdField_a_of_type_Aiqz.jdField_c_of_type_JavaUtilHashMap));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap);
    if ((this.jdField_a_of_type_Aiqy.selectedPhotoList != null) && (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() > 0)) {
      azqs.b(null, "CliOper", "", this.jdField_a_of_type_Aiqy.myUin, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aiqy.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Aiqy.maxSelectNum;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Aiqy.a()) || (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox)) {
        break label82;
      }
      str1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695261, new Object[] { Integer.valueOf(i) });
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
        } while (!this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if (this.jdField_a_of_type_Aiqy.a()) {
      return ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695262, new Object[] { Integer.valueOf(i) });
    }
    return ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695260, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (this.jdField_a_of_type_Aiqy.a()) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aiqy.albumId)) && (this.jdField_a_of_type_Aiqy.albumId.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(xna.a().b());
        bdif.a("PEAK", "getAlbumMedias");
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
          localObject1 = bdfa.getAlbumMedias(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName, i, this.jdField_a_of_type_Aiqz.filter, 0, 0, true, null, false, this.jdField_a_of_type_Aiqz.filterVideoDurationLimit, 1);
          break;
          localObject1 = bdfa.getAlbumMedias(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName, i, this.jdField_a_of_type_Aiqz.filter, this.jdField_a_of_type_Aiqz.filterVideoDurationLimit);
          break;
          localObject2 = localObject1;
        } while (this.jdField_a_of_type_Aiqy.selectedPhotoList == null);
        localObject2 = localObject1;
      } while (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_Aiqy.selectedPhotoList.size());
    Object localObject2 = (String)this.jdField_a_of_type_Aiqy.selectedPhotoList.get(i);
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
        if ((((String)localObject2).startsWith("http")) && (this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.jdField_a_of_type_Aiqy.selectedPhotoList.remove(i);
          i -= 1;
          j = i;
          if (this.jdField_a_of_type_Aiqy.needMediaInfo)
          {
            j = i;
            if (this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap != null)
            {
              j = i;
              if (this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.containsKey(localObject2))
              {
                this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.remove(localObject2);
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
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    RecyclerView localRecyclerView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    bkqn localbkqn = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int i = ((GridLayoutManager)localRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localbkqn.a(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (bkqp)localRecyclerView.getChildViewHolder(localRecyclerView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2));
          if ((localObject != null) && (((bkqp)localObject).a != null)) {
            ((bkqp)localObject).a.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      xna.a().b(localArrayList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap);
    }
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(true);
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.a(paramIntent);
    this.jdField_a_of_type_Aiqz.m = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    aioz.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, false, this.jdField_a_of_type_Aiqz.jdField_c_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.jdField_a_of_type_Aiqy.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Aiqz.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_Aiqz.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.jdField_a_of_type_Aiqy.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.jdField_a_of_type_Aiqz.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Aiqz.f = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Aiqz.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.jdField_a_of_type_Aiqz.h = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Aiqz.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Aiqy.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_Aiqz.isSingleMode = false;
    }
    this.jdField_a_of_type_Aiqz.i = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Aiqz.j = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.jdField_a_of_type_Aiqz.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_Aiqz.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Aiqy.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.jdField_a_of_type_Aiqy.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.jdField_a_of_type_Aiqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.jdField_a_of_type_Aiqz.j)
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
        PhotoUtils.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.currentQualityType, true);
      }
      if (!this.jdField_a_of_type_Aiqz.e) {
        this.jdField_a_of_type_Aiqz.e = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.jdField_a_of_type_Aiqz.e)
      {
        this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.jdField_a_of_type_Aiqz.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.jdField_a_of_type_Aiqz.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.jdField_a_of_type_Aiqy.isShowQzoneAlbum)
      {
        paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), azbu.class);
        paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(bkqs.jdField_a_of_type_Bkqv);
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
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Aiqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
        if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
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
      if ((azdd.b != 0L) && (System.currentTimeMillis() - azdd.b < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + azdd.b);
        }
        if ((!bdin.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719750);
        paramIntent = new AEPhotoListLogicDefault.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (bezm.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 4, new bkrl(this, paramIntent))) {
          bdgm.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 232, null, (String)localObject1, new bkrm(this, paramIntent), new bkrn(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aiqy.currentQualityType, false);
      }
      for (;;)
      {
        azqs.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramArrayList, this.jdField_a_of_type_Aiqy.currentQualityType, this.jdField_a_of_type_Aiqz.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    super.a(paramMessage);
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < aiqy.getInstance().maxSelectNum) {
        break label165;
      }
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), String.format(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695260), new Object[] { Integer.valueOf(aiqy.getInstance().maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      return;
      label165:
      aiqy.getInstance().selectedPhotoList.add(str);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
    }
  }
  
  public void a(View paramView)
  {
    bdfa.clearSelectItemInfo();
    bdfa.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_Aiqy.selectedPhotoList.size();; i = 0)
    {
      aips.b(paramView, i);
      if (this.jdField_a_of_type_Aiqz.i) {
        break;
      }
      if (this.jdField_a_of_type_Aiqy.a()) {
        xna.a().a(xna.a().c());
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      return;
    }
    paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
    bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    if (this.jdField_a_of_type_Aiqz.isSingleMode) {}
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
        localLocalMediaInfo = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
        i = localLocalMediaInfo.selectStatus;
        if ((i == 1) || (paramView.size() < this.jdField_a_of_type_Aiqy.maxSelectNum)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Aiqz.lastTimeShowToast < 1000L);
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), a(localLocalMediaInfo), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
      paramCheckBox.setChecked(false);
      this.jdField_a_of_type_Aiqz.lastTimeShowToast = l;
      k();
      return;
      if ((this.jdField_a_of_type_Aiqz.jdField_a_of_type_Int == 9501) && (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        localObject1 = paramView.iterator();
        for (l = 0L; ((Iterator)localObject1).hasNext(); l = bdhb.a((String)((Iterator)localObject1).next()) + l) {}
        if (bdhb.a(localLocalMediaInfo.path) + l > 52428800L)
        {
          QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "选择图片总大小不能超过50M", 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
          paramCheckBox.setChecked(false);
          return;
        }
      }
      if ((((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (bdhb.a(localLocalMediaInfo.path) > 3145728L))
      {
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "图片文件过大", 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_Int);
        paramCheckBox.setChecked(false);
        return;
      }
    } while ((this.jdField_a_of_type_Aiqy.a()) && (!bnfr.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), localLocalMediaInfo)));
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
      aiqz localaiqz;
      if ((this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localaiqz = this.jdField_a_of_type_Aiqz;
        localaiqz.videoSelectedCnt += 1;
        if (this.jdField_a_of_type_Aiqz.videoSelectedCnt == 1) {
          this.jdField_a_of_type_Aiqz.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localaiqz = this.jdField_a_of_type_Aiqz;
        localaiqz.gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_Aiqy.selectedIndex.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).a(paramCheckBox, 1052, ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("entrance", 0));
      }
      aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_totalSelNum");
      paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
      if (paramView != null) {
        break label1393;
      }
      paramView = new LinkedHashMap();
      bdfa.sSelectItemPosMap.put(this.jdField_a_of_type_Aiqy.albumId, paramView);
    }
    label907:
    label1135:
    label1393:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = bdfa.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName));
      }
      if (this.jdField_a_of_type_Bkrf != null) {
        this.jdField_a_of_type_Bkrf.a(bool1, localLocalMediaInfo);
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.b(bool1);
        d();
        if (!this.jdField_a_of_type_Aiqy.a()) {
          break;
        }
        if (xna.a().a().isEmpty())
        {
          i = ((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
          paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt - i);
          if ((paramView != null) && (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - paramView.getY() < ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int)) {
            ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(xna.jdField_a_of_type_Int, 500);
          }
        }
        xna.a().b(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap);
        return;
        i = 1;
        break label473;
        bool1 = false;
        break label492;
        label1141:
        localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aiqz;
          ((aiqz)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Aiqz.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Aiqz.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aiqz;
          ((aiqz)localObject2).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_Aiqy.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
          this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).b(paramCheckBox, 1013);
        }
        aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bdfa.sSelectItemAlbum;
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
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() > 0)
    {
      paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
      azqs.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), (String)this.jdField_a_of_type_Aiqy.selectedPhotoList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      d(paramView);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (bdfa.a(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.jdField_a_of_type_Int, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap, this.jdField_a_of_type_Aiqz.k, this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695273), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298914));
        this.jdField_a_of_type_Aiqy.currentQualityType = 0;
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Aiqz.jdField_d_of_type_Boolean) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (bdfa.a(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.videoSizeLimit, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap, this.jdField_a_of_type_Aiqz.k, this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131720133), 0).b(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298914));
        bdfa.c();
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_a_of_type_Aiqy.currentQualityType = 2;
      bdfa.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap, this.jdField_a_of_type_Aiqz.k, ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
      continue;
      this.jdField_a_of_type_Aiqy.currentQualityType = 0;
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected void a(bkqp parambkqp, LocalMediaInfo paramLocalMediaInfo)
  {
    if (aioz.a(paramLocalMediaInfo.path, this.jdField_a_of_type_Aiqz.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        parambkqp.e.setImageDrawable(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getDrawable(2130839178));
      }
      for (;;)
      {
        parambkqp.e.setVisibility(0);
        return;
        parambkqp.e.setImageResource(2130839178);
      }
    }
    parambkqp.e.setVisibility(8);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn;
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((bkqn)localObject1).a();
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
        paramSlideItemInfo = ((bkqn)localObject1).a(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aiqz;
          ((aiqz)localObject2).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Aiqz.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Aiqz.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aiqz;
          ((aiqz)localObject2).gifSelectedCount -= 1;
        }
        this.jdField_a_of_type_Aiqy.selectedPhotoList.remove(localObject1);
        this.jdField_a_of_type_Aiqy.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
          this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.remove(localObject1);
        }
        aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = bdfa.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Bkrf != null) {
          this.jdField_a_of_type_Bkrf.a(false, paramSlideItemInfo);
        }
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(i, false);
        d();
        xna.a().b(localArrayList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap);
      }
      label402:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = bdfa.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).f();
      d();
      xna.a().b(localArrayList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap);
      return;
      label562:
      i = -1;
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    aioz.a(paramList, null, this.jdField_a_of_type_Aiqz.jdField_c_of_type_JavaUtilHashMap);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    bdfa.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        azqs.b(null, "CliOper", "", this.jdField_a_of_type_Aiqy.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
        break label365;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiqy.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aiqy.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap);
      aiqz.sPhotoListFirstPos = ((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Aiqz.currentPhotoPath);
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
    if (this.jdField_a_of_type_Aiqz.firstResume)
    {
      this.jdField_a_of_type_Aiqz.firstResume = false;
      if (this.jdField_a_of_type_Aiqz.photoListStartPos != -1) {
        break label385;
      }
      i = aiqz.sPhotoListFirstPos;
      if (i != -1) {
        break label414;
      }
      Object localObject = (LinkedHashMap)bdfa.sSelectItemPosMap.get(this.jdField_a_of_type_Aiqy.albumId);
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
        if (this.jdField_a_of_type_Aiqz.isRecodeLastAlbumPath)
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
      localObject = this.jdField_a_of_type_Aiqy.selectedPhotoList;
      j = i;
      if (i == -1)
      {
        j = i;
        if (this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId"))
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
      i = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.getItemCount();
      if (i != 0) {
        break label423;
      }
      label316:
      if (!this.jdField_a_of_type_Aiqy.a()) {
        break label440;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiqy.a())
      {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
        xna.a().b(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap);
      }
      return true;
      label385:
      i = this.jdField_a_of_type_Aiqz.photoListStartPos;
      break;
      label396:
      k += 1;
      break label157;
      label405:
      k += 1;
      break label261;
      label414:
      aiqz.sPhotoListFirstPos = -1;
      j = i;
      break label295;
      label423:
      if ((j > i - 1) || (j >= 0)) {
        break label316;
      }
      break label316;
      label440:
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPhotoListLogicDefault.9(this));
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aiqy.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_Aiqy.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.jdField_a_of_type_Aiqy.myUin);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!bdeu.a()) {
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719547), 0).a();
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
    } while (localObject1 == null);
    paramView = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (((LocalMediaInfo)localObject1).fileSize > this.jdField_a_of_type_Aiqy.videoSizeLimit)
    {
      paramView = bdgm.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131694953, new bdgx());
      paramView.show();
      return;
    }
    Object localObject2 = bdfa.sSelectItemAlbum;
    Object localObject3;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path))
    {
      localObject3 = new Pair(this.jdField_a_of_type_Aiqy.albumId, this.jdField_a_of_type_Aiqy.albumName);
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject3);
    }
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(((LocalMediaInfo)localObject1).path);
    if (!this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean)
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
      PhotoUtils.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Aiqz.isSingleMode)
    {
      localObject1 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      ((Intent)localObject1).putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
      ((Intent)localObject1).putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
      localObject2 = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(paramInt);
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject2).position);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aiqy.selectedIndex);
      ((Intent)localObject1).putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aiqy.currentQualityType);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aiqz.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString);
      aiqz.sPhotoListFirstPos = ((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      localObject3 = this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap);
      ((Intent)localObject1).setClass(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.jdField_a_of_type_Aiqy.selectedPhotoList != null) && (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() > 0)) {
        azqs.b(null, "CliOper", "", this.jdField_a_of_type_Aiqy.myUin, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aiqy.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aiqy.a()) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
        return;
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity((Intent)localObject1);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      }
    }
    localObject2 = new Intent(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras(paramView);
    ((Intent)localObject2).putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
    ((Intent)localObject2).putExtra("file_send_size", ((LocalMediaInfo)localObject1).fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
    ((Intent)localObject2).putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
    ((Intent)localObject2).putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Aiqz.jdField_d_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_Aiqz.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    if (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aiqy.selectedPhotoList);
    }
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject2, 17);
  }
  
  public void b(String paramString)
  {
    Intent localIntent = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    HashMap localHashMap = this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aiqy.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aiqy.albumId);
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
    if ((i > 0) && (i < ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.getItemCount()))
    {
      localObject = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn.a(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    aiqz.sPhotoListFirstPos = ((GridLayoutManager)((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    c(localIntent);
    bdfa.anim(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), true, true);
  }
  
  public View c()
  {
    return super.c();
  }
  
  public void c()
  {
    Object localObject = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView;
    int i;
    if ((this.jdField_a_of_type_Aiqz.isSingleMode) || (this.jdField_a_of_type_Aiqz.showMediaType == 2) || (this.jdField_a_of_type_Aiqy.a()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      if (!this.jdField_a_of_type_Aiqz.e) {
        break label347;
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiqz.jdField_c_of_type_Boolean) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      }
      d();
      if (this.jdField_a_of_type_Aiqy.a())
      {
        this.jdField_a_of_type_Aiqz.jdField_a_of_type_Xne = new xne(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this);
        xna.a().a(this.jdField_a_of_type_Aiqz.jdField_a_of_type_Xne);
        xna.a().a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
        l();
        if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (xnh)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((xnh)localObject).a();
          }
          ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label347:
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    if (!this.jdField_a_of_type_Aiqy.selectedPhotoList.isEmpty()) {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Aiqy.selectedPhotoList.get(this.jdField_a_of_type_Aiqy.selectedPhotoList.size() - 1));
    }
    bdfa.a();
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Aiqy.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bdhb.a((String)paramView.next()) + l) {}
      if (arrr.a())
      {
        arre.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131692754, 2131692759, new bkro(this));
        return;
      }
    }
    i();
  }
  
  public void c(View paramView, int paramInt)
  {
    if (!bdeu.a())
    {
      QQToast.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719547), 0).a();
      return;
    }
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).g();
  }
  
  protected void d()
  {
    super.d();
    ArrayList localArrayList = this.jdField_a_of_type_Aiqy.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_a_of_type_Aiqz.e) {
        break label422;
      }
      if ((localArrayList.size() != 1) || ((this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Aiqy.jdField_a_of_type_JavaUtilHashMap.size() > 0)) || (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localArrayList.get(0)) != 0)) {
        break label402;
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Aiqz.jdField_c_of_type_Boolean)
      {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0)
        {
          ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
          ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setEnabled(true);
        }
      }
      j();
      if (!this.jdField_a_of_type_Aiqz.jdField_d_of_type_Boolean) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label402:
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      label422:
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void d(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aiqz.l)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void e()
  {
    super.e();
    aofm.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Aiqz.requestCode == 100016) {
      if (!((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      }
    }
    do
    {
      return;
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.jdField_a_of_type_Aiqz.requestCode = 0;
      if (((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton != null) {
        ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!this.jdField_a_of_type_Aiqy.a());
    xna.a().c();
    xna.a().a(this.jdField_a_of_type_Aiqz.jdField_a_of_type_Xne);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aiqy.isShowQzoneAlbum) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(bkqs.jdField_a_of_type_Bkqv);
    }
    if (this.jdField_a_of_type_Aiqy.a()) {
      xna.a().f();
    }
    super.f();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Aiqy.albumId.equals("$RecentAlbumId")) {
      azri.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Aiqz.e) || ((TextUtils.isEmpty(this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.jdField_a_of_type_Aiqy.albumName.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Aiqy.albumName.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Aiqy.albumName.contains("Camera")) || (this.jdField_a_of_type_Aiqy.albumName.contains("camera"))) {
        azri.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        azri.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList != null)
    {
      aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_Aiqy.selectedPhotoList.size());
      aips.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent(), this.jdField_a_of_type_Aiqy.selectedPhotoList.size(), this.jdField_a_of_type_Aiqy.currentQualityType);
    }
    Intent localIntent = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_Aiqy.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      azqs.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.jdField_a_of_type_Aiqy.needMediaInfo) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap);
      }
      if (this.jdField_a_of_type_Aiqy.selectedPhotoList != null) {
        ajrw.a(this.jdField_a_of_type_Aiqy.selectedPhotoList);
      }
      d(localIntent);
      a(localIntent, false, this.jdField_a_of_type_Aiqy.selectedPhotoList);
      return;
      if ((localPresendPicMgr != null) && (!this.jdField_a_of_type_Aiqz.l) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  public void j()
  {
    aiqy localaiqy = this.jdField_a_of_type_Aiqy;
    switch (localaiqy.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    bdfa.a(((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_d_of_type_AndroidWidgetTextView, localaiqy.selectedPhotoList, localaiqy.allMediaInfoHashMap, this.jdField_a_of_type_Aiqz.k, ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap, localaiqy.selectedMediaInfoHashMap);
    ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Aiqz.l) {
      azqs.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  void l()
  {
    Object localObject = xna.a().a();
    if (this.jdField_a_of_type_Aiqz.m) {
      xna.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.jdField_a_of_type_Aiqy.selectedPhotoList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Aiqy.selectedPhotoList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Aiqy.selectedIndex.contains(localSlideItemInfo.a.position)) {
          this.jdField_a_of_type_Aiqy.selectedIndex.add(localSlideItemInfo.a.position);
        }
        this.jdField_a_of_type_Aiqy.selectedMediaInfoHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.a);
      }
    }
    if (this.jdField_a_of_type_Aiqy.selectedPhotoList.size() > 0) {
      xna.a().a(this.jdField_a_of_type_Aiqy.selectedPhotoList, this.jdField_a_of_type_Aiqy.allMediaInfoHashMap, false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((bkqs)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bkqn;
      } while ((localObject == null) || (((bkqn)localObject).a == null));
      localObject = (LocalMediaInfo)((bkqn)localObject).a.get(paramInt);
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
 * Qualified Name:     bkrk
 * JD-Core Version:    0.7.0.1
 */