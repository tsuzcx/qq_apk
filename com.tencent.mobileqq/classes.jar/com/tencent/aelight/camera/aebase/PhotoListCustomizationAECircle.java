package com.tencent.aelight.camera.aebase;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class PhotoListCustomizationAECircle
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.aelight.camera.aebase.PhotoListCustomizationAECircle";
  private static final int i = ;
  private static final String[] j = { "video/mp4", "video/3gpp" };
  private int k = 0;
  private Dialog l;
  private int m = 3000;
  private int n = 3000;
  private int o = 3600000;
  private int p;
  private boolean q;
  
  public PhotoListCustomizationAECircle(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    AEQLog.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.c != null) && (!this.c.isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.l == null)
        {
          this.l = new Dialog(this.c, 2131953338);
          this.l.setCancelable(false);
          this.l.setCanceledOnTouchOutside(false);
          this.l.setContentView(2131625585);
        }
        this.l.show();
        return;
      }
      Dialog localDialog = this.l;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.l.dismiss();
      }
    }
  }
  
  private void d()
  {
    AEEditorJumpUtil.a(this.k, this.c, this.e, false);
    this.c.finish();
    b(false);
  }
  
  /* Error */
  private int h(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 127	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore_3
    //   5: lload_3
    //   6: aload_0
    //   7: getfield 53	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:o	I
    //   10: i2l
    //   11: lcmp
    //   12: ifgt +110 -> 122
    //   15: lload_3
    //   16: ldc2_w 128
    //   19: lcmp
    //   20: ifge +5 -> 25
    //   23: iconst_1
    //   24: ireturn
    //   25: new 131	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 133	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_1
    //   37: getfield 136	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   40: invokevirtual 140	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   43: aload 6
    //   45: bipush 12
    //   47: invokevirtual 144	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: getstatic 39	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:j	[Ljava/lang/String;
    //   55: iconst_0
    //   56: aaload
    //   57: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +28 -> 88
    //   63: aload_1
    //   64: getstatic 39	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:j	[Ljava/lang/String;
    //   67: iconst_1
    //   68: aaload
    //   69: invokevirtual 148	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +12 -> 88
    //   79: iconst_3
    //   80: istore_2
    //   81: aload 6
    //   83: invokevirtual 151	android/media/MediaMetadataRetriever:release	()V
    //   86: iload_2
    //   87: ireturn
    //   88: aload 6
    //   90: invokevirtual 151	android/media/MediaMetadataRetriever:release	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_1
    //   96: goto +19 -> 115
    //   99: astore_1
    //   100: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   110: iconst_5
    //   111: istore_2
    //   112: goto -31 -> 81
    //   115: aload 6
    //   117: invokevirtual 151	android/media/MediaMetadataRetriever:release	()V
    //   120: aload_1
    //   121: athrow
    //   122: iconst_1
    //   123: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	PhotoListCustomizationAECircle
    //   0	124	1	paramLocalMediaInfo	LocalMediaInfo
    //   80	32	2	i1	int
    //   4	12	3	l1	long
    //   72	3	5	bool	boolean
    //   32	84	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   34	74	95	finally
    //   100	110	95	finally
    //   34	74	99	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    String str = this.c.getString(2131914046);
    int i1 = this.e.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i1);
    localStringBuilder.append("/");
    localStringBuilder.append(this.e.maxSelectNum - this.p);
    str = localStringBuilder.toString();
    this.h.o.setText(str);
    if (i1 == 0)
    {
      this.h.o.setBackgroundResource(2130851880);
      this.h.o.setEnabled(false);
      return;
    }
    this.h.o.setBackgroundResource(2130837935);
    this.h.o.setEnabled(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 10019))
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  public void a(Intent paramIntent)
  {
    AEResUtil.j();
    super.a(paramIntent);
    int i1 = AECameraEntry.y.a();
    if (AECameraEntryManager.r(this.c.getIntent())) {
      i1 = AECameraEntry.A.a();
    }
    AEBaseReportParam.a().a(i1, null);
    String str = this.c.getIntent().getStringExtra("intent_key_uid_for_report");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = AECaptureContext.a().getCurrentAccountUin();
      this.c.getIntent().putExtra("intent_key_uid_for_report", (String)localObject);
    }
    AEBaseReportParam.a().c((String)localObject);
    AEBaseReportParam.a().d();
    AEBaseReportParam.a().b();
    AEBaseReportParam.a().d(CameraOperationHelper.a());
    AEBaseReportParam.a().e(CameraOperationHelper.b());
    AEBaseReportParam.a().a(ParamsUtil.b());
    localObject = this.c.getIntent().getStringExtra("albumName");
    str = this.c.getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.e.albumName = ((String)localObject);
      this.e.albumId = str;
    }
    this.p = this.c.getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.q = this.c.getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AdditionalPick] initData---initialHasPickedNum=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(", canPickVideo=");
    ((StringBuilder)localObject).append(this.q);
    AEQLog.a("PhotoListCustomizationAECircle", ((StringBuilder)localObject).toString());
    this.m = 3000;
    this.n = 3000;
    this.o = i;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("qq_camera_from_qcircle_scheme"))) {
      QQToast.makeText(this.c, 0, HardCodeUtil.a(2131886319), 1).show();
    }
    AEReportUtils.a(false, "1");
  }
  
  public void a(View paramView)
  {
    this.h.o.setClickable(false);
    d();
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    int i1 = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1)
    {
      int i2 = this.k;
      if (i2 == 1)
      {
        if (this.e.selectedPhotoList.size() == 1)
        {
          if (i1 == 0) {
            QQToast.makeText(this.c, HardCodeUtil.a(2131886371), 0).show();
          }
          return;
        }
        if (this.e.selectedPhotoList.size() == 0)
        {
          if (i1 == 0) {
            this.k = 0;
          }
        }
        else {
          AEQLog.d("PhotoListCustomizationAECircle", "[error] size > 1 && mDataType = video");
        }
      }
      else if (i2 == 0)
      {
        if (i1 == 0)
        {
          if (QAlbumUtil.isGif(localLocalMediaInfo))
          {
            QQToast.makeText(this.c, HardCodeUtil.a(2131886369), 0).show();
            return;
          }
          if ((localLocalMediaInfo.mediaWidth >= 20) && (localLocalMediaInfo.mediaHeight >= 20))
          {
            if (this.e.selectedPhotoList.size() + this.p >= 9)
            {
              paramView = BaseApplicationImpl.sApplication.getResources().getString(2131886370, new Object[] { Integer.valueOf(9 - this.p) });
              QQToast.makeText(this.c, paramView, 0).show();
            }
          }
          else {
            QQToast.makeText(this.c, HardCodeUtil.a(2131886365), 0).show();
          }
        }
      }
      else
      {
        AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
      }
    }
    else
    {
      i1 = this.k;
      if (i1 == 1) {
        this.k = 0;
      } else if (i1 != 0) {
        AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
      }
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QAlbumUtil.isGif(paramLocalMediaInfo))
    {
      QQToast.makeText(this.c, HardCodeUtil.a(2131886369), 0).show();
      return false;
    }
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.b.B) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {
      return false;
    }
    int i1 = paramLocalMediaInfo.selectStatus;
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {
      return false;
    }
    if ((i1 == 2) && (paramBoolean) && (this.e.selectedPhotoList.size() + this.p >= 9))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.b.H >= 700L)
      {
        paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2131886370, new Object[] { Integer.valueOf(9 - this.p) });
        QQToast.makeText(this.c, paramLocalMediaInfo, 0).show();
        this.b.H = l1;
        this.b.I = true;
      }
      return false;
    }
    this.b.I = false;
    if (paramBoolean) {
      a(paramLocalMediaInfo);
    } else {
      b(paramLocalMediaInfo);
    }
    this.h.b(paramBoolean ^ true);
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    return super.a(paramList);
  }
  
  public Intent b(View paramView, int paramInt)
  {
    paramView = super.b(paramView, paramInt);
    paramView.putExtra("choosed_num", this.e.selectedPhotoList.size());
    paramView.putExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", this.p);
    LocalMediaInfo localLocalMediaInfo1 = this.h.t.a(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i6 = this.e.mediaPathsList.size();
    int i3 = 0;
    int i2 = paramInt;
    int i4;
    for (int i1 = 0; i3 < i6; i1 = i4)
    {
      String str = (String)this.e.mediaPathsList.get(i3);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.e.allMediaInfoHashMap.get(str);
      int i5 = i2;
      i4 = i1;
      if (AlbumUtil.getMediaType(localLocalMediaInfo2) == 0)
      {
        localArrayList1.add(str);
        if ((this.e.selectedPhotoList != null) && (this.e.selectedPhotoList.contains(str))) {
          localArrayList2.add(Integer.valueOf(i1));
        }
        if (localLocalMediaInfo2.position.intValue() == paramInt) {
          i2 = i1;
        }
        i4 = i1 + 1;
        i5 = i2;
      }
      i3 += 1;
      i2 = i5;
    }
    this.e.mediaPathsList = localArrayList1;
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
    if (AlbumUtil.getMediaType(localLocalMediaInfo1) == 0) {
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i2);
    }
    return paramView;
  }
  
  public void b(Intent paramIntent)
  {
    this.c.startActivityForResult(paramIntent, 10019);
  }
  
  public void b(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = this.c.getIntent();
    int i1;
    if (this.e.selectedPhotoList != null) {
      i1 = this.e.selectedPhotoList.size();
    } else {
      i1 = 0;
    }
    StatisticConstants.b(paramView, i1);
    if (!this.b.l)
    {
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
      return;
    }
    paramView = this.c.getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null) {
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      this.c.startActivity(paramView);
    }
    else
    {
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
        QZoneHelper.launchQZone(this.c, str3, paramView, 2);
      }
    }
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
  
  public void c(View paramView, int paramInt)
  {
    if ((this.e.selectedPhotoList.size() == 0) && (this.q))
    {
      LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
      int i1 = h(localLocalMediaInfo);
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4)
              {
                if (i1 != 5) {
                  return;
                }
                QQToast.makeText(this.c, HardCodeUtil.a(2131886375), 0).show();
                return;
              }
              QQToast.makeText(this.c, HardCodeUtil.a(2131886372), 0).show();
              return;
            }
            QQToast.makeText(this.c, HardCodeUtil.a(2131886374), 0).show();
            return;
          }
          QQToast.makeText(this.c, HardCodeUtil.a(2131886373), 0).show();
          return;
        }
        QQToast.makeText(this.c, String.format(HardCodeUtil.a(2131886364), new Object[] { Integer.valueOf(2), Integer.valueOf(i / 60 / 1000) }), 0).show();
        return;
      }
      this.k = 1;
      this.e.selectedPhotoList.add(localLocalMediaInfo.path);
      this.e.selectedIndex.add(Integer.valueOf(paramInt));
      this.e.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      Object localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.e.albumId);
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.e.albumId, paramView);
      }
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(this.h.m.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        localObject = new Pair(this.e.albumId, this.e.albumName);
        paramView.put(localLocalMediaInfo.path, localObject);
      }
      d();
      return;
    }
    QQToast.makeText(this.c, HardCodeUtil.a(2131886371), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PhotoListCustomizationAECircle
 * JD-Core Version:    0.7.0.1
 */