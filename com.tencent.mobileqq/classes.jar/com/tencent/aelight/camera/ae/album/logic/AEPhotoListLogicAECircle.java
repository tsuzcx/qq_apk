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
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.VideoUtil;
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
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private int jdField_b_of_type_Int = 3000;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 3000;
  
  public AEPhotoListLogicAECircle(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    super(paramAENewPhotoListFragment);
    AEQLog.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
  }
  
  private ProgressPieDrawable a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return null;
    }
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.c(0);
    localProgressPieDrawable.a(new AEPhotoListLogicAECircle.5(this));
    return localProgressPieDrawable;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.a();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    c(true);
    a(paramLocalMediaInfo, new AEPhotoListLogicAECircle.3(this, System.currentTimeMillis(), paramLocalMediaInfo, paramInt));
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1)
    {
      paramInt2 = this.jdField_a_of_type_Int;
      if (paramInt2 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (paramInt1 == 0) {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515225), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
        {
          if (paramInt1 == 0)
          {
            this.jdField_a_of_type_Int = 0;
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
          if (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramLocalMediaInfo))
          {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515223), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
          if ((paramLocalMediaInfo.mediaWidth >= 20) && (paramLocalMediaInfo.mediaHeight >= 20))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
            {
              paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2064515224, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
              QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramLocalMediaInfo, 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
              return true;
            }
          }
          else
          {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515217), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
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
      paramInt1 = this.jdField_a_of_type_Int;
      if (paramInt1 == 1)
      {
        this.jdField_a_of_type_Int = 0;
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
          break label261;
        }
      }
      AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] time error");
      return false;
    }
    catch (NumberFormatException paramString)
    {
      break label243;
    }
    catch (IllegalArgumentException paramString)
    {
      label233:
      label243:
      break label233;
    }
    AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] IllegalArgumentException");
    return false;
    AEQLog.d("PhotoListCustomizationAECircle", "[checkVideoIsOK] NumberFormatException");
    return false;
    label261:
    return true;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    if (!StringUtil.a((String)localObject))
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
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    boolean bool = false;
    if ((i == 0) && (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canPickVideo))
    {
      LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
      i = a(localLocalMediaInfo);
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
          c(false);
          QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515227), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          return;
        }
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      Object localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, localObject1);
      }
      ((LinkedHashMap)localObject1).put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(localLocalMediaInfo.path))
      {
        localObject2 = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        ((HashMap)localObject1).put(localLocalMediaInfo.path, localObject2);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        AEQLog.b("PhotoListCustomizationAECircle", "updateWMProps onGetLocation");
        WatermarkDataManager.a().a(new AEPhotoListLogicAECircle.1(this));
      }
      j();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool, true, 1, paramInt);
      return;
    }
    QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515225), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  private void c(int paramInt)
  {
    int i = a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt));
    if ((i != 0) && (i != 2))
    {
      d(i);
      return;
    }
    a(paramInt, (AEAbstractPhotoListFragment.PhotoVH)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null) && (!((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (paramBoolean)
      {
        if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null))
        {
          this.jdField_b_of_type_AndroidAppDialog = new Dialog(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131756189);
          this.jdField_b_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_b_of_type_AndroidAppDialog.setContentView(2064318588);
          localObject = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2064122301);
          Button localButton = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2064121988);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
          localButton.setOnClickListener(new AEPhotoListLogicAECircle.4(this));
        }
        this.jdField_b_of_type_AndroidAppDialog.show();
        return;
      }
      Object localObject = this.jdField_b_of_type_AndroidAppDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing()))
      {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = null;
        this.jdField_b_of_type_AndroidAppDialog = null;
      }
    }
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
          QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515229), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          return;
        }
        QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515226), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
      }
      QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2064515228), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    }
    QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131756189);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  private void j()
  {
    AEEditorJumpUtil.a(this.jdField_a_of_type_Int, ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, true);
    d(false);
  }
  
  /* Error */
  protected int a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 568	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore 4
    //   6: lload 4
    //   8: ldc2_w 569
    //   11: lcmp
    //   12: ifgt +157 -> 169
    //   15: lload 4
    //   17: ldc2_w 571
    //   20: lcmp
    //   21: ifge +5 -> 26
    //   24: iconst_1
    //   25: ireturn
    //   26: new 286	android/media/MediaMetadataRetriever
    //   29: dup
    //   30: invokespecial 287	android/media/MediaMetadataRetriever:<init>	()V
    //   33: astore 7
    //   35: aload 7
    //   37: aload_1
    //   38: getfield 141	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   41: invokevirtual 291	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   44: aload 7
    //   46: bipush 19
    //   48: invokevirtual 294	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 575	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   54: istore_2
    //   55: aload 7
    //   57: bipush 18
    //   59: invokevirtual 294	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: invokestatic 575	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: istore_3
    //   66: aload 7
    //   68: bipush 12
    //   70: invokevirtual 294	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   73: astore_1
    //   74: iload_2
    //   75: aload_0
    //   76: getfield 34	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:c	I
    //   79: if_icmpgt +58 -> 137
    //   82: iload_3
    //   83: aload_0
    //   84: getfield 32	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:jdField_b_of_type_Int	I
    //   87: if_icmple +6 -> 93
    //   90: goto +47 -> 137
    //   93: aload_1
    //   94: getstatic 23	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   97: iconst_0
    //   98: aaload
    //   99: invokevirtual 578	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +28 -> 130
    //   105: aload_1
    //   106: getstatic 23	com/tencent/aelight/camera/ae/album/logic/AEPhotoListLogicAECircle:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   109: iconst_1
    //   110: aaload
    //   111: invokevirtual 578	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: istore 6
    //   116: iload 6
    //   118: ifne +12 -> 130
    //   121: iconst_3
    //   122: istore_2
    //   123: aload 7
    //   125: invokevirtual 581	android/media/MediaMetadataRetriever:release	()V
    //   128: iload_2
    //   129: ireturn
    //   130: aload 7
    //   132: invokevirtual 581	android/media/MediaMetadataRetriever:release	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: iconst_2
    //   138: istore_2
    //   139: goto -16 -> 123
    //   142: astore_1
    //   143: goto +19 -> 162
    //   146: astore_1
    //   147: invokestatic 586	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 589	java/lang/Exception:printStackTrace	()V
    //   157: iconst_5
    //   158: istore_2
    //   159: goto -36 -> 123
    //   162: aload 7
    //   164: invokevirtual 581	android/media/MediaMetadataRetriever:release	()V
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
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.jdField_b_of_type_Int = 3000;
    this.c = 3000;
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h)
    {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
    }
    else
    {
      paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
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
        ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      }
      else
      {
        paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
        str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
        String str3 = paramView.getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str2))
        {
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
          QZoneHelper.launchQZone(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
        }
      }
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
    }
    AEBaseDataReporter.a().b(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    int j = localLocalMediaInfo.selectStatus;
    if ((!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (a(localLocalMediaInfo, i, j))) {
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
    if (localObject != null) {
      ((MovieExporter)localObject).cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    localObject = b(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, (String)localObject, localOutputConfig, new AEPhotoListLogicAECircle.2(this, paramVideoCompressListener, (String)localObject));
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    paramBoolean = super.a(paramList, paramBoolean);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      paramList = (AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (AECameraEntryManager.k(paramList))
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
  
  protected boolean b()
  {
    return this.jdField_b_of_type_AndroidAppDialog != null;
  }
  
  public void c(View paramView)
  {
    j();
  }
  
  protected void d()
  {
    super.d();
    String str = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131716583);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum;
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
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setText((CharSequence)localObject);
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {
      i = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.minSelectNumForMix;
    } else {
      i = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.minSelectNumForNormal;
    }
    if (j < i)
    {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(false);
      return;
    }
    ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(true);
  }
  
  protected void h()
  {
    MovieExporter localMovieExporter = this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
    if (localMovieExporter != null) {
      localMovieExporter.cancelCompress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle
 * JD-Core Version:    0.7.0.1
 */