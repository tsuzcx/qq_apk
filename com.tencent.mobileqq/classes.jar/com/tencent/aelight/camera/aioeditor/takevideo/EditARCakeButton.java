package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.content.FileProvider;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.CACHE;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.AIOWXShareListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class EditARCakeButton
  extends EditVideoPart
  implements View.OnClickListener
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final ArrayList<ShareActionSheetBuilder.ActionSheetItem> d = new ArrayList();
  private View e;
  private View f;
  private View g;
  private View h;
  private AIOShareObject i;
  private String j;
  private final DialogInterface.OnDismissListener k = new EditARCakeButton.2(this);
  private final IAIOShareHelper.AIOWXShareListener l = new EditARCakeButton.3(this);
  private final ShareActionSheet.OnItemClickListener m = new EditARCakeButton.4(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.CACHE.a);
    localStringBuilder.append("/qq_aio_share");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/qq_share_video.mp4");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/qq_share_video_thumb.png");
    c = localStringBuilder.toString();
  }
  
  public EditARCakeButton(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private String a(String paramString)
  {
    String str = b;
    if (FileUtil.a(new File(paramString), new File(str)))
    {
      paramString = new StringBuilder();
      paramString.append("save video to temp path success, path = ");
      paramString.append(str);
      AEQLog.b("EditARCakeButton", paramString.toString());
      return str;
    }
    paramString = new StringBuilder();
    paramString.append("save video to temp path fail, path = ");
    paramString.append(str);
    AEQLog.d("EditARCakeButton", paramString.toString());
    return null;
  }
  
  private void a(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    paramString = new File(paramString);
    Intent localIntent = new Intent("android.intent.action.SEND");
    try
    {
      int n = Build.VERSION.SDK_INT;
      if (n >= 24)
      {
        localIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(paramActivity, "com.tencent.mobileqq.fileprovider", paramString));
        localIntent.addFlags(1);
      }
      else
      {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramString));
      }
      localIntent.setType("video/*");
      paramActivity.startActivity(Intent.createChooser(localIntent, ""));
      return;
    }
    catch (Exception paramActivity)
    {
      AEQLog.a("EditARCakeButton", paramActivity);
    }
  }
  
  @WorkerThread
  private void a(String paramString, boolean paramBoolean)
  {
    AEQLog.b("EditARCakeButton", "build share object");
    if (paramBoolean)
    {
      this.i = AIOShareObject.a(paramString);
      return;
    }
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    Object localObject3 = localObject5;
    Object localObject4 = localObject6;
    try
    {
      l();
      localObject2 = localObject1;
      localObject3 = localObject5;
      localObject4 = localObject6;
      String str = a(paramString);
      if (str == null) {
        return;
      }
      localObject2 = localObject1;
      localObject3 = localObject5;
      localObject4 = localObject6;
      localObject1 = AIOShareObject.b(str);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      paramString = b(paramString);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      ((AIOShareObject)localObject1).c(paramString.d).a(paramString.a, paramString.b).b(paramString.c);
    }
    catch (Throwable paramString)
    {
      AEQLog.a("EditARCakeButton", "make share video obj error", paramString);
      localObject1 = localObject2;
    }
    catch (IllegalArgumentException paramString)
    {
      AEQLog.a("EditARCakeButton", "make share video obj error", paramString);
      localObject1 = localObject3;
    }
    catch (IOException paramString)
    {
      AEQLog.a("EditARCakeButton", "make share video obj error", paramString);
      localObject1 = localObject4;
    }
    this.i = ((AIOShareObject)localObject1);
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new EditARCakeButton.5(this, paramBoolean));
  }
  
  @NonNull
  private EditARCakeButton.ShareVideoMetaInfo b(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start decode video meta info, path = ");
    ((StringBuilder)localObject1).append(paramString);
    AEQLog.b("EditARCakeButton", ((StringBuilder)localObject1).toString());
    localObject1 = new EditARCakeButton.ShareVideoMetaInfo(null);
    Object localObject2 = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
    paramString = ((MediaMetadataRetriever)localObject2).extractMetadata(18);
    String str1 = ((MediaMetadataRetriever)localObject2).extractMetadata(19);
    String str2 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
    ((EditARCakeButton.ShareVideoMetaInfo)localObject1).a = Integer.parseInt(paramString);
    ((EditARCakeButton.ShareVideoMetaInfo)localObject1).b = Integer.parseInt(str1);
    ((EditARCakeButton.ShareVideoMetaInfo)localObject1).c = Integer.parseInt(str2);
    paramString = new StringBuilder();
    paramString.append("video width = ");
    paramString.append(((EditARCakeButton.ShareVideoMetaInfo)localObject1).a);
    paramString.append(", height = ");
    paramString.append(((EditARCakeButton.ShareVideoMetaInfo)localObject1).b);
    paramString.append(", duration = ");
    paramString.append(((EditARCakeButton.ShareVideoMetaInfo)localObject1).c);
    AEQLog.b("EditARCakeButton", paramString.toString());
    AEQLog.b("EditARCakeButton", "start decode video thumbnail");
    paramString = ((MediaMetadataRetriever)localObject2).getFrameAtTime();
    ((EditARCakeButton.ShareVideoMetaInfo)localObject1).d = c;
    localObject2 = new FileOutputStream(new File(((EditARCakeButton.ShareVideoMetaInfo)localObject1).d));
    paramString.compress(Bitmap.CompressFormat.PNG, 50, (OutputStream)localObject2);
    AEQLog.b("EditARCakeButton", "decode video thumbnail success");
    return localObject1;
  }
  
  private void c()
  {
    a(true);
  }
  
  private void d()
  {
    a(false);
  }
  
  private void i()
  {
    this.h.setEnabled(false);
    String str = this.t.I.e.a();
    boolean bool = this.t.j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start share, is photo = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", source path = ");
    localStringBuilder.append(str);
    AEQLog.b("EditARCakeButton", localStringBuilder.toString());
    ThreadManager.getFileThreadHandler().post(new EditARCakeButton.1(this, str, bool));
  }
  
  @MainThread
  private void k()
  {
    if (this.i == null) {
      return;
    }
    if (this.u.getActivity() != null)
    {
      if (this.u.getActivity().isFinishing()) {
        return;
      }
      Object localObject1 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject1).context = u();
      localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
      ((ShareActionSheet)localObject1).setOnDismissListener(this.k);
      ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 8);
      ((ShareActionSheet)localObject1).setActionSheetItems(m(), d);
      ((ShareActionSheet)localObject1).setItemClickListenerV2(this.m);
      Object localObject2 = u();
      if ((localObject2 instanceof Activity))
      {
        localObject2 = ((Activity)localObject2).getIntent();
        if (localObject2 != null)
        {
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_arvideo");
          ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
        }
      }
      ((ShareActionSheet)localObject1).show();
      AEQLog.b("EditARCakeButton", "share panel action sheet has shown");
    }
  }
  
  private void l()
  {
    File localFile = new File(a);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> m()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(50));
    if (this.t.j())
    {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      return localArrayList;
    }
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(64));
    return localArrayList;
  }
  
  private String n()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public void a()
  {
    super.a();
    ((ViewStub)d(2063991461)).inflate();
    this.e = d(2063990890);
    this.f = this.e.findViewById(2063991173);
    this.f.setOnClickListener(this);
    this.g = this.e.findViewById(2063990917);
    this.g.setOnClickListener(this);
    this.h = this.e.findViewById(2063990928);
    this.h.setOnClickListener(this);
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportARVideoExpose();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    boolean bool = true;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      if (paramInt2 != -1) {
        bool = false;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("onActivity result: success = ");
      paramIntent.append(bool);
      AEQLog.b("EditARCakeButton", paramIntent.toString());
      if (bool)
      {
        c();
        return;
      }
      d();
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == 2063991173)
    {
      this.t.b();
      return;
    }
    if (n == 2063990917)
    {
      ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportARVideoDownloadBtn();
      this.t.A();
      return;
    }
    if (n == 2063990928)
    {
      ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportARVideoShareBtn();
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton
 * JD-Core Version:    0.7.0.1
 */