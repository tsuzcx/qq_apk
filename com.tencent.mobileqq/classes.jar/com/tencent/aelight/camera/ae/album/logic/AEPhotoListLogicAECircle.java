package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.usq.u;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class AEPhotoListLogicAECircle
  extends AEPhotoListLogicDefault
{
  private static final String[] o = { "video/mp4", "video/3gpp" };
  private MovieExporter m;
  private ProgressPieDrawable n;
  private int p = 0;
  private Dialog q;
  private Dialog r;
  private int s = 3000;
  private int t = 3000;
  private boolean u = false;
  
  public AEPhotoListLogicAECircle(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    super(paramAENewPhotoListFragment);
    AEQLog.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    d(true);
    a(paramLocalMediaInfo, new AEPhotoListLogicAECircle.3(this, System.currentTimeMillis(), paramLocalMediaInfo, paramInt));
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1)
    {
      paramInt2 = this.p;
      if (paramInt2 == 1)
      {
        if (this.c.selectedPhotoList.size() == 1)
        {
          if (paramInt1 == 0) {
            QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187572), 0).show(((AENewPhotoListFragment)this.b.get()).i);
          }
          return true;
        }
        if (this.c.selectedPhotoList.size() == 0)
        {
          if (paramInt1 == 0)
          {
            this.p = 0;
            return false;
          }
        }
        else
        {
          AEQLog.d("PhotoListCustomizationAECircle", "[error] size > 1 && mDataType = video");
          return false;
        }
      }
      else if (paramInt2 == 0)
      {
        if (paramInt1 == 0)
        {
          if (((AENewPhotoListFragment)this.b.get()).a(paramLocalMediaInfo))
          {
            QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187570), 0).show(((AENewPhotoListFragment)this.b.get()).i);
            return true;
          }
          if ((paramLocalMediaInfo.mediaWidth >= 20) && (paramLocalMediaInfo.mediaHeight >= 20))
          {
            if (this.c.selectedPhotoList.size() + this.e.initialHasPickedNum >= this.c.maxSelectNum)
            {
              paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2064187571, new Object[] { Integer.valueOf(this.c.maxSelectNum) });
              QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), paramLocalMediaInfo, 0).show(((AENewPhotoListFragment)this.b.get()).i);
              return true;
            }
          }
          else
          {
            QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187564), 0).show(((AENewPhotoListFragment)this.b.get()).i);
            return true;
          }
        }
      }
      else
      {
        AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
        return false;
      }
    }
    else
    {
      paramInt1 = this.p;
      if (paramInt1 == 1)
      {
        this.p = 0;
        return false;
      }
      if (paramInt1 == 0) {
        return false;
      }
      AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
    }
    return false;
  }
  
  private boolean a(String paramString, long paramLong)
  {
    try
    {
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      long l1 = Long.parseLong(((MediaMetadataRetriever)localObject).extractMetadata(20));
      long l2 = Long.parseLong(((MediaMetadataRetriever)localObject).extractMetadata(18));
      long l3 = Long.parseLong(((MediaMetadataRetriever)localObject).extractMetadata(19));
      long l4 = Long.parseLong(((MediaMetadataRetriever)localObject).extractMetadata(9));
      long l5 = FileUtils.getFileSizes(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("compress finish!\n outputPath: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\n outputDuring: ");
      ((StringBuilder)localObject).append(l4);
      ((StringBuilder)localObject).append("\n outputWidth: ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("\n outputHeight: ");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("\n outputBitrate: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("\n outputSize: ");
      ((StringBuilder)localObject).append(l5);
      ((StringBuilder)localObject).append(" bytes");
      AEQLog.d("PhotoListCustomizationAECircle", ((StringBuilder)localObject).toString());
      if (l4 <= paramLong + 1000L) {
        if (l4 >= paramLong - 1000L) {
          break label251;
        }
      }
      AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] time error");
      return false;
    }
    catch (NumberFormatException paramString)
    {
      break label234;
    }
    catch (IllegalArgumentException paramString)
    {
      label225:
      label234:
      break label225;
    }
    AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] IllegalArgumentException");
    return false;
    AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] NumberFormatException");
    return false;
    label251:
    return true;
  }
  
  private void b(int paramInt)
  {
    if (this.r != null) {
      return;
    }
    int i = this.c.selectedPhotoList.size();
    boolean bool = false;
    if ((i == 0) && (this.e.canPickVideo))
    {
      LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.b.get()).d.a(paramInt);
      i = b(localLocalMediaInfo);
      if (i != 0)
      {
        if (i != 2)
        {
          d(i);
          return;
        }
        try
        {
          a(paramInt, localLocalMediaInfo);
          return;
        }
        catch (Exception localException)
        {
          AEQLog.d("PhotoListCustomizationAECircle", localException.toString());
          d(false);
          QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187574), 0).show(((AENewPhotoListFragment)this.b.get()).i);
          return;
        }
      }
      this.p = 1;
      this.c.selectedPhotoList.add(localLocalMediaInfo.path);
      this.c.selectedIndex.add(Integer.valueOf(paramInt));
      this.c.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      Object localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.c.albumId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.c.albumId, localObject1);
      }
      ((LinkedHashMap)localObject1).put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.b.get()).r.getLayoutManager()).findFirstVisibleItemPosition()));
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(localLocalMediaInfo.path))
      {
        localObject2 = new Pair(this.c.albumId, this.c.albumName);
        ((HashMap)localObject1).put(localLocalMediaInfo.path, localObject2);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (((AENewPhotoListFragment)this.b.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        AEQLog.b("PhotoListCustomizationAECircle", "updateWMProps onGetLocation");
        WatermarkDataManager.a().a(new AEPhotoListLogicAECircle.1(this));
      }
      p();
      this.c.selectedPhotoList.clear();
      if (this.e.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool, true, 1, paramInt, "1");
      return;
    }
    QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187572), 0).show(((AENewPhotoListFragment)this.b.get()).i);
  }
  
  @NotNull
  private String c(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    if (!StringUtil.isEmpty((String)localObject))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append((String)localObject);
      paramLocalMediaInfo.append(".mp4");
      paramLocalMediaInfo = paramLocalMediaInfo.toString();
    }
    else
    {
      paramLocalMediaInfo = paramLocalMediaInfo.path.split("/");
      if (paramLocalMediaInfo.length > 0) {
        paramLocalMediaInfo = paramLocalMediaInfo[(paramLocalMediaInfo.length - 1)];
      } else {
        paramLocalMediaInfo = "";
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEEditorPath.EDITOR.CACHE.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLocalMediaInfo);
    return ((StringBuilder)localObject).toString();
  }
  
  private void c(int paramInt)
  {
    int i = b(((AENewPhotoListFragment)this.b.get()).d.a(paramInt));
    if ((i != 0) && (i != 2))
    {
      d(i);
      return;
    }
    a(paramInt, (AEAbstractPhotoListFragment.PhotoVH)((AENewPhotoListFragment)this.b.get()).r.findViewHolderForAdapterPosition(paramInt));
  }
  
  private EncoderWriter.OutputConfig d(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.b();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187576), 0).show(((AENewPhotoListFragment)this.b.get()).i);
          return;
        }
        QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187573), 0).show(((AENewPhotoListFragment)this.b.get()).i);
        return;
      }
      QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), HardCodeUtil.a(2064187575), 0).show(((AENewPhotoListFragment)this.b.get()).i);
      return;
    }
    QQToast.makeText(((AENewPhotoListFragment)this.b.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).show(((AENewPhotoListFragment)this.b.get()).i);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.b.get() != null) && (((AENewPhotoListFragment)this.b.get()).getActivity() != null) && (!((AENewPhotoListFragment)this.b.get()).getActivity().isFinishing()))
    {
      if (paramBoolean)
      {
        if ((this.r == null) || (this.n == null))
        {
          this.r = new Dialog(((AENewPhotoListFragment)this.b.get()).getActivity(), 2131953338);
          this.r.setCancelable(false);
          this.r.setCanceledOnTouchOutside(false);
          this.r.setContentView(2064056460);
          localObject = (ImageView)this.r.findViewById(2063991180);
          Button localButton = (Button)this.r.findViewById(2063990915);
          this.n = o();
          ((ImageView)localObject).setImageDrawable(this.n);
          localButton.setOnClickListener(new AEPhotoListLogicAECircle.4(this));
        }
        this.r.show();
        return;
      }
      Object localObject = this.r;
      if ((localObject != null) && (((Dialog)localObject).isShowing()))
      {
        this.r.dismiss();
        this.n = null;
        this.r = null;
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.b.get() != null) && (!((AENewPhotoListFragment)this.b.get()).getActivity().isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.q == null)
        {
          this.q = new Dialog(((AENewPhotoListFragment)this.b.get()).getActivity(), 2131953338);
          this.q.setCancelable(false);
          this.q.setCanceledOnTouchOutside(false);
          this.q.setContentView(2131625585);
        }
        this.q.show();
        return;
      }
      Dialog localDialog = this.q;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.q.dismiss();
      }
    }
  }
  
  private ProgressPieDrawable o()
  {
    if (this.b.get() == null) {
      return null;
    }
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(((AENewPhotoListFragment)this.b.get()).getActivity());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, ((AENewPhotoListFragment)this.b.get()).getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.d(0);
    localProgressPieDrawable.a(new AEPhotoListLogicAECircle.5(this));
    return localProgressPieDrawable;
  }
  
  private void p()
  {
    AEEditorJumpUtil.a(this.p, ((AENewPhotoListFragment)this.b.get()).getActivity(), this.c, true);
    e(false);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.c.albumName = paramIntent;
      this.c.albumId = str;
    }
    this.s = 3000;
    this.t = 3000;
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
    int i;
    if (this.c.selectedPhotoList != null) {
      i = this.c.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.l.l)
    {
      ((AENewPhotoListFragment)this.b.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.b.get()).getActivity(), false, false);
    }
    else
    {
      paramView = ((AENewPhotoListFragment)this.b.get()).getActivity().getIntent();
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
        ((AENewPhotoListFragment)this.b.get()).startActivity(paramView);
      }
      else
      {
        paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
        str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
        String str3 = paramView.getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str2))
        {
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
          QZoneHelper.launchQZone(((AENewPhotoListFragment)this.b.get()).getActivity(), str3, paramView, 2);
        }
      }
      ((AENewPhotoListFragment)this.b.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.b.get()).getActivity(), false, false);
    }
    AEBaseDataReporter.a().b(System.currentTimeMillis() - this.a);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.e.canMixPhotoAndVideo)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.b.get()).d.a(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    int j = localLocalMediaInfo.selectStatus;
    if ((!this.e.canMixPhotoAndVideo) && (a(localLocalMediaInfo, i, j))) {
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((MovieExporter)localObject).cancelCompress();
    }
    this.m = new MovieExporter();
    localObject = c(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = d(paramLocalMediaInfo);
    this.m.compressVideo(paramLocalMediaInfo.path, (String)localObject, localOutputConfig, new AEPhotoListLogicAECircle.2(this, paramVideoCompressListener, (String)localObject));
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    paramBoolean = super.a(paramList, paramBoolean);
    if (!this.u)
    {
      this.u = true;
      paramList = (AENewPhotoListFragment)this.b.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (AECameraEntryManager.o(paramList))
        {
          long l2 = System.currentTimeMillis();
          long l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
          l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
          if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L))
          {
            if (l2 < 0L) {
              return paramBoolean;
            }
            AEBaseDataReporter.a().a(l1, l2);
          }
        }
      }
    }
    return paramBoolean;
  }
  
  /* Error */
  protected int b(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 757	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore 4
    //   6: lload 4
    //   8: ldc2_w 758
    //   11: lcmp
    //   12: ifgt +157 -> 169
    //   15: lload 4
    //   17: ldc2_w 760
    //   20: lcmp
    //   21: ifge +5 -> 26
    //   24: iconst_1
    //   25: ireturn
    //   26: new 198	android/media/MediaMetadataRetriever
    //   29: dup
    //   30: invokespecial 200	android/media/MediaMetadataRetriever:<init>	()V
    //   33: astore 7
    //   35: aload 7
    //   37: aload_1
    //   38: getfield 282	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   41: invokevirtual 204	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   44: aload 7
    //   46: bipush 19
    //   48: invokevirtual 207	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 764	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   54: istore_2
    //   55: aload 7
    //   57: bipush 18
    //   59: invokevirtual 207	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: invokestatic 764	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: istore_3
    //   66: aload 7
    //   68: bipush 12
    //   70: invokevirtual 207	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   73: astore_1
    //   74: iload_2
    //   75: aload_0
    //   76: getfield 40	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:t	I
    //   79: if_icmpgt +58 -> 137
    //   82: iload_3
    //   83: aload_0
    //   84: getfield 38	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:s	I
    //   87: if_icmple +6 -> 93
    //   90: goto +47 -> 137
    //   93: aload_1
    //   94: getstatic 29	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:o	[Ljava/lang/String;
    //   97: iconst_0
    //   98: aaload
    //   99: invokevirtual 670	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +28 -> 130
    //   105: aload_1
    //   106: getstatic 29	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:o	[Ljava/lang/String;
    //   109: iconst_1
    //   110: aaload
    //   111: invokevirtual 670	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: istore 6
    //   116: iload 6
    //   118: ifne +12 -> 130
    //   121: iconst_3
    //   122: istore_2
    //   123: aload 7
    //   125: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   128: iload_2
    //   129: ireturn
    //   130: aload 7
    //   132: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: iconst_2
    //   138: istore_2
    //   139: goto -16 -> 123
    //   142: astore_1
    //   143: goto +19 -> 162
    //   146: astore_1
    //   147: invokestatic 772	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   157: iconst_5
    //   158: istore_2
    //   159: goto -36 -> 123
    //   162: aload 7
    //   164: invokevirtual 767	android/media/MediaMetadataRetriever:release	()V
    //   167: aload_1
    //   168: athrow
    //   169: iconst_1
    //   170: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AEPhotoListLogicAECircle
    //   0	171	1	paramLocalMediaInfo	LocalMediaInfo
    //   54	105	2	i	int
    //   65	23	3	j	int
    //   4	12	4	l	long
    //   114	3	6	bool	boolean
    //   33	130	7	localMediaMetadataRetriever	MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   35	90	142	finally
    //   93	116	142	finally
    //   147	157	142	finally
    //   35	90	146	java/lang/Exception
    //   93	116	146	java/lang/Exception
  }
  
  public void c(View paramView)
  {
    p();
  }
  
  protected void d()
  {
    super.d();
    String str = ((AENewPhotoListFragment)this.b.get()).getString(2131914046);
    int j = this.c.selectedPhotoList.size() + this.e.initialHasPickedNum;
    Object localObject = str;
    if (j != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    ((AENewPhotoListFragment)this.b.get()).t.setText((CharSequence)localObject);
    int i;
    if (this.e.canMixPhotoAndVideo) {
      i = this.e.minSelectNumForMix;
    } else {
      i = this.e.minSelectNumForNormal;
    }
    if (j < i)
    {
      ((AENewPhotoListFragment)this.b.get()).t.setEnabled(false);
      return;
    }
    ((AENewPhotoListFragment)this.b.get()).t.setEnabled(true);
  }
  
  protected void i()
  {
    MovieExporter localMovieExporter = this.m;
    if (localMovieExporter != null) {
      localMovieExporter.cancelCompress();
    }
  }
  
  protected boolean l()
  {
    return this.r != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle
 * JD-Core Version:    0.7.0.1
 */