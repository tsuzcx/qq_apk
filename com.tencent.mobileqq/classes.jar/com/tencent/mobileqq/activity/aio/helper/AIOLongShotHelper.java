package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAioLongShot;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.ReflectionUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;

public class AIOLongShotHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private int A;
  private int B;
  private AIOLongShotHelper.MergeBitmapTask C;
  private BaseChatPie a;
  private Set<ChatMessage> b = new HashSet();
  private boolean c;
  private int d;
  private boolean e;
  private List<ViewGroup> f = new ArrayList();
  private boolean g;
  private TextView h;
  private TextView i;
  private CheckBox j;
  private TextView k;
  private Button l;
  private QQProgressDialog m;
  private TextView n;
  private RelativeLayout o;
  private Handler p = new Handler(Looper.getMainLooper());
  private boolean q;
  private ChatXListView r;
  private List<Bitmap> s = new ArrayList();
  private ChatAdapter1 t;
  private int u;
  private int v;
  private Bitmap w;
  private Runnable x;
  private Field y;
  private Bitmap z;
  
  public AIOLongShotHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  private void A()
  {
    QQProgressDialog localQQProgressDialog = this.m;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.m = null;
    }
  }
  
  private int B()
  {
    Object localObject = this.b.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext()) {
      i1 += e((ChatMessage)((Iterator)localObject).next());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCheckedMessagesHeight() called height = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  private void C()
  {
    Object localObject = Runtime.getRuntime();
    long l1 = (((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L;
    long l2 = ((Runtime)localObject).maxMemory() / 1048576L;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("printMemoryInfo: maxHeapSizeInMB=");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append("MB, usedMemInMB=");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("MB, availHeapSizeInMB=");
    ((StringBuilder)localObject).append(l2 - l1);
    ((StringBuilder)localObject).append("MB");
    QLog.e("AIOLongShotHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  private int a(int paramInt)
  {
    if (this.b.isEmpty()) {
      return -1;
    }
    List localList = this.a.V.a();
    paramInt -= 1;
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.b.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      int i1;
      try
      {
        int i2 = this.z.getHeight();
        i1 = paramInt3 + paramInt2 + i2;
        try
        {
          if (!QLog.isColorLevel()) {
            break label284;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("tryCreateBitmap() height = [");
          localStringBuilder.append(i1);
          localStringBuilder.append("], inputBarBitmapHeight = [");
          localStringBuilder.append(i2);
          localStringBuilder.append("], listViewHeight = [");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], titleBarHeight = [");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append("]");
          QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        }
        catch (Throwable localThrowable1)
        {
          StringBuilder localStringBuilder;
          paramInt2 = i1;
          break label209;
        }
        return Bitmap.createBitmap(paramInt1, i1, Bitmap.Config.RGB_565);
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryCreateBitmap: size overflow. width = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(", w*h = ");
      localStringBuilder.append(paramInt1 * i1);
      QLog.e("AIOLongShotHelper", 1, localStringBuilder.toString());
      return null;
      label209:
      QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 1 ", localThrowable2);
      Runtime.getRuntime().gc();
      try
      {
        Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
        return localBitmap1;
      }
      catch (Throwable localThrowable3)
      {
        QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 2 ", localThrowable3);
        Runtime.getRuntime().gc();
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
          return localBitmap2;
        }
        catch (Throwable localThrowable4)
        {
          QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 3 ", localThrowable4);
          return null;
        }
      }
      label284:
      if ((paramInt1 < 30000) && (i1 < 30000)) {
        if (paramInt1 * i1 < 200000000) {}
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("regionCheck() called with: start = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], end = [");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.V.a();
    while ((paramInt1 >= 0) && (paramInt1 < ((List)localObject).size()) && (paramInt1 < paramInt2))
    {
      this.b.add(((List)localObject).get(paramInt1));
      paramInt1 += 1;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramIntent.getExtras();
    if (localObject != null) {
      localArrayList.add(((Bundle)localObject).getString("forward_filepath"));
    } else {
      QLog.e("AIOLongShotHelper", 1, "sendPicToFriend: empty extras");
    }
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
    localObject = ForwardUtils.a(paramIntent);
    localIntent.putExtra("uin", ((SessionInfo)localObject).b);
    localIntent.putExtra("uintype", ((SessionInfo)localObject).a);
    localIntent.putExtra("troop_uin", ((SessionInfo)localObject).c);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", ((SessionInfo)localObject).s);
    localIntent.putExtra("KEY_MSG_FORWARD_ID", paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
    if (localArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    }
    paramActivity.startActivityForResult(localIntent, 18002);
  }
  
  private static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("forward_type", 1);
    localIntent.setData(Uri.parse(paramString));
    paramActivity.startActivityForResult(localIntent, 18001);
  }
  
  public static void a(Activity paramActivity, String paramString, AIOLongShotHelper.OnActionSheetAction paramOnActionSheetAction)
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(paramActivity);
    localActionSheet.addButton(2131890804);
    if ((PicShareToWX.b().e()) && (PicShareToWX.b().a(paramString))) {
      localActionSheet.addButton(2131890813);
    }
    localActionSheet.addButton(2131890810);
    localActionSheet.addButton(2131890802);
    localActionSheet.addButton(2131889842);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new AIOLongShotHelper.3(paramActivity, localActionSheet, paramString, paramOnActionSheetAction));
    localActionSheet.show();
    a("0X8009DF0");
  }
  
  private void a(Context paramContext)
  {
    A();
    this.m = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131299920));
    this.m.a(HardCodeUtil.a(2131898363));
    this.m.show();
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      a(false, false, null);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("encodeAndWritePNG() called with: bitmap.bytes = [");
    ((StringBuilder)localObject1).append(paramBitmap.getByteCount() / 1048576L);
    ((StringBuilder)localObject1).append("MB], width=");
    ((StringBuilder)localObject1).append(paramBitmap.getWidth());
    ((StringBuilder)localObject1).append(", height = ");
    ((StringBuilder)localObject1).append(paramBitmap.getHeight());
    QLog.d("AIOLongShotHelper", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject1).append("/Tencent/MobileQQ/aio_long_shot/");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    } else {
      FileUtils.deleteFilesInDirectory((String)localObject1);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".png");
    localObject1 = ((StringBuilder)localObject2).toString();
    FileUtils.saveBitmapToFile(paramBitmap, (String)localObject1, Bitmap.CompressFormat.PNG);
    paramBitmap.recycle();
    a(false, true, (String)localObject1);
  }
  
  private void a(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.w;
    if (localBitmap != null)
    {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      localBitmap.recycle();
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.a.n(paramBoolean);
    this.a.V.notifyDataSetChanged();
  }
  
  private void a(ChatMessage paramChatMessage, Bitmap paramBitmap)
  {
    this.c = true;
    q();
    if (paramBitmap == null) {
      e();
    }
    this.a.c(paramChatMessage);
    this.a.U.a(true);
    if (o())
    {
      a(false);
      m();
    }
    paramChatMessage = this.a;
    if ((paramChatMessage instanceof BaseTroopChatPie))
    {
      paramChatMessage = (AIOShortcutBarHelper)paramChatMessage.q(52);
      if (paramChatMessage != null) {
        paramChatMessage.d(16);
      }
    }
    paramChatMessage = this.a;
    if (((paramChatMessage instanceof TroopChatPie)) || ((paramChatMessage instanceof FriendChatPie))) {
      this.a.v.setVisibility(8);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void a(List<ChatMessage> paramList)
  {
    this.r = new ChatXListView(this.a.aX());
    this.r.setChatPie(this.a);
    this.r.setDividerHeight(0);
    this.r.setVerticalScrollBarEnabled(false);
    this.r.setStackFromBottom(true);
    this.r.setTranscriptMode(0);
    this.r.setClipChildren(false);
    this.r.setShouldPlayVideo(false);
    this.t = new ChatAdapter1(this.a.d, this.a.f, this.a.ah, this.a.aU, this.a);
    this.t.a(this.a.V.f());
    this.t.a(paramList, null);
    this.r.setAdapter(this.t);
    paramList = this.a.aX().getWindow().getDecorView();
    if (!(paramList instanceof FrameLayout)) {
      return;
    }
    paramList = (FrameLayout)paramList;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.r.setLayoutParams(localLayoutParams);
    paramList.addView(this.r, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    this.a.e.getSharedPreferences("AIOLongShotHelper", 0).edit().putBoolean("KEY_IS_FIRST_USE", paramBoolean).apply();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.p.post(new AIOLongShotHelper.1(this, paramBoolean1, paramBoolean2, paramString));
  }
  
  private boolean a(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    try
    {
      if (this.y == null) {
        this.y = ReflectionUtil.a("android.view.View", "mGroupFlags");
      }
      this.y.setAccessible(true);
      int i1 = this.y.getInt(paramViewGroup);
      if ((i1 & 0x1) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramViewGroup)
    {
      QLog.d("AIOLongShotHelper", 1, paramViewGroup, new Object[0]);
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    if (this.b.isEmpty()) {
      return -1;
    }
    List localList = this.a.V.a();
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.b.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: drawingCache == null");
      return null;
    }
    int i1 = this.v;
    if (i1 == -1) {
      i1 = this.r.getChildCount() - 1;
    } else {
      i1 -= this.r.getFirstVisiblePosition();
    }
    if ((i1 < 0) || (i1 >= this.r.getChildCount()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCropBitmap: getFirstVisiblePosition=");
      ((StringBuilder)localObject).append(this.r.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(", mSelectionPosition=");
      ((StringBuilder)localObject).append(this.v);
      QLog.e("AIOLongShotHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.r.getChildAt(i1);
    if (localObject == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: selectedView == null");
      return null;
    }
    int i2 = ((View)localObject).getBottom() - this.u;
    if (i2 <= paramBitmap.getHeight())
    {
      i1 = i2;
      if (i2 > 0) {}
    }
    else
    {
      i1 = paramBitmap.getHeight();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCropBitmap: invalid height mOverlapY=");
      localStringBuilder.append(this.u);
      localStringBuilder.append(", getBottom = ");
      localStringBuilder.append(((View)localObject).getBottom());
      QLog.e("AIOLongShotHelper", 1, localStringBuilder.toString());
    }
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i1);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", localThrowable);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i1);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", paramBitmap);
      }
    }
    return null;
  }
  
  private List<ChatMessage> b(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
      ChatMessage localChatMessage2 = d(localChatMessage1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy() called with: cm = [");
        localStringBuilder.append(localChatMessage1);
        localStringBuilder.append("]");
        QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy() called with: copyChatMessage = [");
        localStringBuilder.append(localChatMessage2);
        localStringBuilder.append("]");
        QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
      }
      if (localChatMessage2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "copy src message failed. Try to use src message.", new IllegalArgumentException(localChatMessage1.toString()));
        localArrayList.add(localChatMessage1);
      }
      else
      {
        localArrayList.add(localChatMessage2);
      }
    }
    return localArrayList;
  }
  
  private static void b(Activity paramActivity, View paramView, int paramInt, ActionSheet paramActionSheet, String paramString, AIOLongShotHelper.OnActionSheetAction paramOnActionSheetAction)
  {
    if (paramView == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    String str = paramActionSheet.getContent(paramInt);
    if (str == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramActionSheet.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131890804)))
    {
      a(paramActivity, paramString);
      a("0X8009DF1");
    }
    else if (str.equals(paramView.getResources().getString(2131890813)))
    {
      a("0X800A502");
      if ((paramActivity instanceof SplashActivity))
      {
        paramView = ((AppActivity)paramActivity).getAppRuntime();
        if ((paramView instanceof QQAppInterface))
        {
          paramView = (QQAppInterface)paramView;
          PicShareToWX.b().a(paramActivity, paramView, paramString, 2);
        }
      }
      else
      {
        PicShareToWX.a(paramString, paramActivity, 2);
      }
    }
    else if (str.equals(paramView.getResources().getString(2131890810)))
    {
      paramActivity = new File(paramString);
      paramString = paramActivity.getAbsolutePath();
      com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils.a((Activity)paramView.getContext(), paramActivity, Utils.Crc64String(paramString));
      if (paramOnActionSheetAction != null) {
        paramOnActionSheetAction.a();
      }
      a("0X8009DF2");
    }
    else if (str.equals(paramView.getResources().getString(2131890802)))
    {
      if (paramOnActionSheetAction != null) {
        paramOnActionSheetAction.b();
      }
      paramActivity.runOnUiThread(new AIOLongShotHelper.4(paramString, paramActivity));
      a("0X8009DF3");
    }
    else if (str.equals(paramView.getResources().getString(2131889842)))
    {
      com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.a(paramActivity, paramString, 100);
      a("0X800A77C");
    }
    paramActionSheet.dismiss();
  }
  
  private void b(Canvas paramCanvas)
  {
    ChatBackground localChatBackground = this.a.ah.H;
    if (localChatBackground != null)
    {
      Object localObject1 = localChatBackground.c;
      boolean bool = AnonymousChatHelper.a().a(this.a.ah.b);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("drawBackground() called with: isAnonymous = [");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      QLog.d("AIOLongShotHelper", 1, ((StringBuilder)localObject2).toString());
      if (bool)
      {
        localObject2 = i();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          QLog.e("AIOLongShotHelper", 1, "drawBackground: Anonymous bg == null");
          localObject1 = localChatBackground.c;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130852162);
      }
      if (localObject2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawBackground: getDefaultThemeDrawable bg == null");
        return;
      }
      int i1 = paramCanvas.getHeight();
      paramCanvas.save();
      while (i1 > 0)
      {
        int i2 = ((Drawable)localObject2).getBounds().height();
        i1 -= i2;
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.translate(0.0F, i2);
      }
      paramCanvas.restore();
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    paramView.setDrawingCacheEnabled(paramBoolean);
    paramView.destroyDrawingCache();
    if ((paramView instanceof ViewGroup))
    {
      int i1 = 0;
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i1 >= localViewGroup.getChildCount()) {
          break;
        }
        b(localViewGroup.getChildAt(i1), paramBoolean);
        i1 += 1;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGenerateFile() called with: path = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
    }
    int i1 = this.d;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          this.l.setEnabled(true);
          c(paramString);
        }
      }
      else
      {
        this.i.setEnabled(true);
        d(paramString);
      }
    }
    else
    {
      this.h.setEnabled(true);
      e(paramString);
    }
    A();
  }
  
  private ChatMessage c(ChatMessage paramChatMessage)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (localChatMessage.uniseq == paramChatMessage.uniseq) {
        return localChatMessage;
      }
    }
    return null;
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = this.s.size() - 1;
    int i2 = 0;
    while (i1 >= 0)
    {
      Bitmap localBitmap = (Bitmap)this.s.get(i1);
      if (localBitmap == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawListView: mBitmapList.bm == null");
      }
      else
      {
        paramCanvas.drawBitmap(localBitmap, 0.0F, i2, null);
        i2 += localBitmap.getHeight();
        localBitmap.recycle();
      }
      i1 -= 1;
    }
  }
  
  private void c(View paramView)
  {
    paramView = this.f.iterator();
    while (paramView.hasNext()) {
      ((ViewGroup)paramView.next()).setClipChildren(false);
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    a(this.a.f, paramString, new AIOLongShotHelper.2(this));
  }
  
  private ChatMessage d(ChatMessage paramChatMessage)
  {
    paramChatMessage = (ChatMessage)paramChatMessage.deepCopyByReflect();
    if (paramChatMessage != null)
    {
      if ((paramChatMessage instanceof MessageForArkApp)) {
        ((MessageForArkApp)paramChatMessage).arkContainer = null;
      }
      if ((paramChatMessage instanceof MessageForArkFlashChat)) {
        ((MessageForArkFlashChat)paramChatMessage).arkContainer = null;
      }
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        Object localObject = (MessageForArkBabyqReply)paramChatMessage;
        if ((((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList != null) && (((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList.size() > 0))
        {
          localObject = ((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
            if (localArkBabyqCardInfo != null) {
              localArkBabyqCardInfo.mArkBabyqContainer = null;
            }
          }
        }
      }
      if ((paramChatMessage instanceof IMessageForApollo)) {
        ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).copyChatMessage(paramChatMessage);
      }
    }
    return paramChatMessage;
  }
  
  private void d(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.z;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, paramCanvas.getHeight() - localBitmap.getHeight(), null);
    }
  }
  
  private void d(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (!a(paramView)) {
        this.f.add(paramView);
      }
      paramView.setClipChildren(true);
      int i1 = 0;
      while (i1 < paramView.getChildCount())
      {
        d(paramView.getChildAt(i1));
        i1 += 1;
      }
    }
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    BaseActivity localBaseActivity = this.a.f;
    localBaseActivity.startActivityForResult(((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(localBaseActivity, paramString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null), 18003);
  }
  
  private int e(ChatMessage paramChatMessage)
  {
    int i2 = paramChatMessage.getViewHeight();
    int i1 = i2;
    if (i2 == 0) {
      i1 = f(paramChatMessage);
    }
    return i1;
  }
  
  private void e(View paramView)
  {
    this.d = 2;
    paramView.setEnabled(false);
    a(paramView.getContext());
    p();
  }
  
  private void e(String paramString)
  {
    if (paramString == null) {
      return;
    }
    BaseActivity localBaseActivity = this.a.f;
    Intent localIntent = new Intent();
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("uin", this.a.ah.b);
    localIntent.putExtra("uintype", this.a.ah.a);
    localIntent.putExtra("troop_uin", this.a.ah.c);
    localIntent.putExtra("uinname", this.a.ah.e);
    boolean bool = localBaseActivity instanceof SplashActivity;
    if (bool)
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, null);
    }
    else
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("key_activity_code", ChatActivityUtils.a(localBaseActivity));
    if (this.a.ah.a == 9501)
    {
      if (bool)
      {
        localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localIntent = AIOUtils.a(localIntent, null);
      }
      else
      {
        localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      localIntent.putExtra(AlbumConstants.h, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    else
    {
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.a.ah.v);
    }
    localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
    localIntent.setClass(localBaseActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("enter_from", 42);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAioLongShot.a);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
    localIntent.setClass(localBaseActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    localBaseActivity.startActivityForResult(localIntent, 18004);
    this.g = true;
  }
  
  private int f(ChatMessage paramChatMessage)
  {
    ChatXListView localChatXListView = this.a.U;
    int i4 = localChatXListView.getChildCount();
    int i3 = 0;
    int i1 = 0;
    View localView;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        return i2;
      }
      localView = localChatXListView.getChildAt(i1);
      if ((localView != null) && (paramChatMessage.equals(localView.getTag(2131430591)))) {
        break;
      }
      i1 += 1;
    }
    int i2 = localView.getHeight();
    return i2;
  }
  
  public static AIOLongShotHelper f()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).k() != null)) {
        return (AIOLongShotHelper)((ChatFragment)localObject).k().q(15);
      }
    }
    return null;
  }
  
  private void f(View paramView)
  {
    this.d = 1;
    paramView.setEnabled(false);
    a(paramView.getContext());
    p();
  }
  
  private void g(View paramView)
  {
    this.d = 0;
    paramView.setEnabled(false);
    a(paramView.getContext());
    this.p.post(new AIOLongShotHelper.12(this));
  }
  
  private int h(View paramView)
  {
    int i1 = 0;
    if (paramView == null) {
      return 0;
    }
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i1 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramView.getHeight() + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return i1;
  }
  
  private Drawable i()
  {
    return ((ViewGroup)this.a.U.getParent()).getChildAt(0).getBackground();
  }
  
  private void i(View paramView)
  {
    paramView = paramView.getDrawingCache();
    int i1 = this.a.X.getTop();
    this.z = Bitmap.createBitmap(paramView, 0, i1, paramView.getWidth(), paramView.getHeight() - i1);
    paramView = this.z;
    if (paramView == null) {
      QLog.e("AIOLongShotHelper", 1, "createInputBarBitmap: mInputBarBitmap == null");
    } else {
      this.A = paramView.getHeight();
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("createInputBarBitmap() mInputBarHeight = [");
      paramView.append(this.A);
      paramView.append("]");
      QLog.d("AIOLongShotHelper", 2, paramView.toString());
    }
  }
  
  private int j()
  {
    return this.a.p.getHeight();
  }
  
  private void k()
  {
    boolean bool = this.b.isEmpty() ^ true;
    this.h.setEnabled(bool);
    this.i.setEnabled(bool);
    this.j.setEnabled(bool);
    this.k.setEnabled(bool);
    this.l.setEnabled(bool);
  }
  
  private void l()
  {
    boolean bool = this.b.isEmpty();
    this.n.setEnabled(bool ^ true);
  }
  
  private void m()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    int i1 = AIOUtils.b(248.0F, this.a.e.getResources());
    int i2 = (int)(i1 * 420.0F / 472.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i2;
    localObject = URLDrawable.getDrawable("https://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", (URLDrawable.URLDrawableOptions)localObject);
    localObject = DialogUtil.a(this.a.e, 230).setTitle(HardCodeUtil.a(2131898361)).setMessage(HardCodeUtil.a(2131898365)).setPreviewImage((Drawable)localObject, true, 0).setPreviewFixDimension(i1, i2);
    ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131898366), new AIOLongShotHelper.5(this));
    ((QQCustomDialog)localObject).show();
  }
  
  private void n()
  {
    if (o()) {
      ThreadManagerV2.executeOnNetWorkThread(new AIOLongShotHelper.6(this));
    }
  }
  
  private boolean o()
  {
    return this.a.e.getSharedPreferences("AIOLongShotHelper", 0).getBoolean("KEY_IS_FIRST_USE", true);
  }
  
  private void p()
  {
    Object localObject = new ArrayList();
    List localList = this.a.V.a();
    int i1 = 0;
    while (i1 < localList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i1);
      if (this.b.contains(localChatMessage)) {
        ((List)localObject).add(localChatMessage);
      }
      i1 += 1;
    }
    localObject = b((List)localObject);
    y();
    w();
    a((List)localObject);
    r();
  }
  
  private void q()
  {
    this.s.clear();
    this.u = 0;
    this.v = -1;
    this.r = null;
    this.t = null;
    this.w = null;
  }
  
  private void r()
  {
    if (this.x == null) {
      this.x = new AIOLongShotHelper.13(this);
    }
    this.p.removeCallbacks(this.x);
    int i1 = 150;
    Object localObject = this.t.a();
    int i3 = ((List)localObject).size() - 1;
    for (;;)
    {
      i2 = i1;
      if (i3 < 0) {
        break label168;
      }
      i2 = i1;
      if (i3 < ((List)localObject).size() - 1 - 10) {
        break label168;
      }
      ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(i3);
      if (!(localChatMessage instanceof MessageForPic))
      {
        i2 = i1;
        if (!(localChatMessage instanceof MessageForScribble)) {}
      }
      else
      {
        i2 = Math.max(250, i1);
      }
      i1 = i2;
      if ((localChatMessage instanceof MessageForShortVideo)) {
        i1 = Math.max(500, i2);
      }
      if (((localChatMessage instanceof MessageForArkApp)) || ((localChatMessage instanceof IMessageForApollo))) {
        break;
      }
      i3 -= 1;
    }
    int i2 = Math.max(750, i1);
    label168:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scheduleSampleBitmap() called maxDelay = ");
      ((StringBuilder)localObject).append(i2);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    this.p.postDelayed(this.x, i2);
  }
  
  private void s()
  {
    if ((!t()) && (this.B < 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sampleBitmap: not rendered now. Try again. mRetryRender = ");
      ((StringBuilder)localObject).append(this.B);
      QLog.e("AIOLongShotHelper", 1, ((StringBuilder)localObject).toString());
      r();
      this.B += 1;
      return;
    }
    this.B = 0;
    this.r.setDrawingCacheEnabled(true);
    Object localObject = b(this.r.getDrawingCache());
    this.s.add(localObject);
    b(this.r, false);
    int i1 = this.r.getFirstVisiblePosition();
    localObject = this.r.getChildAt(0);
    if ((i1 == 0) && (((View)localObject).getTop() >= 0))
    {
      w();
      x();
      u();
      localObject = this.C;
      if (localObject != null) {
        ((AIOLongShotHelper.MergeBitmapTask)localObject).a();
      }
      this.C = new AIOLongShotHelper.MergeBitmapTask(this);
      ThreadManagerV2.executeOnSubThread(this.C);
      return;
    }
    this.u = (((View)localObject).getBottom() - this.r.getTop());
    if (this.u == ((View)localObject).getHeight())
    {
      this.v = (i1 - 1);
      this.u = 0;
    }
    else
    {
      this.v = i1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scheduleSampleBitmap() called y = ");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(", position = ");
      ((StringBuilder)localObject).append(this.v);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.t.a();
    i1 = ((List)localObject).size() - 1;
    while (i1 > this.v)
    {
      ((List)localObject).remove(i1);
      i1 -= 1;
    }
    this.t.notifyDataSetChanged();
    this.r.setSelectionFromBottom(this.v, -this.u);
    r();
  }
  
  private boolean t()
  {
    int i2 = this.r.getFirstVisiblePosition();
    int i1 = 0;
    while (i1 < this.r.getChildCount())
    {
      Object localObject = this.t.getItem(i2 + i1);
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        ChatMessage localChatMessage = c((ChatMessage)localObject);
        if (localChatMessage == null) {
          return false;
        }
        int i3;
        if (((ChatMessage)localObject).mNeedTimeStamp)
        {
          if (localChatMessage.mNeedTimeStamp)
          {
            if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight()) {
              return false;
            }
          }
          else
          {
            i3 = h(this.r.getChildAt(i1).findViewById(2131430611));
            if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight() + i3) {
              return false;
            }
          }
        }
        else if (localChatMessage.mNeedTimeStamp)
        {
          i3 = h(this.r.getChildAt(i1).findViewById(2131430611));
          if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight() - i3) {
            return false;
          }
        }
        else if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight())
        {
          return false;
        }
      }
      i1 += 1;
    }
    return true;
  }
  
  private void u()
  {
    NavBarAIO localNavBarAIO = this.a.p;
    if (d())
    {
      this.f.clear();
      d(localNavBarAIO);
    }
    View localView1 = this.a.aX().findViewById(2131447534);
    View localView2 = this.a.aX().findViewById(2131446540);
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    localNavBarAIO.setDrawingCacheEnabled(true);
    this.w = localNavBarAIO.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    if (QQTheme.isSimpleWhite()) {
      this.w = a(this.w, this.a.bd, localNavBarAIO.getTop());
    }
    if (this.w == null) {
      QLog.e("AIOLongShotHelper", 1, "createTitleBitmap: mTitleBitmap == null");
    }
    localNavBarAIO.setDrawingCacheEnabled(false);
    localView1.setVisibility(4);
    localView2.setVisibility(4);
    if (d())
    {
      c(localNavBarAIO);
      this.f.clear();
    }
  }
  
  private Bitmap v()
  {
    if (this.w == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mTitleBitmap == null");
      return null;
    }
    if (this.z == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mInputBarBitmap == null");
      return null;
    }
    Object localObject1 = this.s.iterator();
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Bitmap)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mBitmapList.bm == null");
        return null;
      }
      i3 = i2;
      if (i2 == 0) {
        i3 = ((Bitmap)localObject2).getWidth();
      }
      int i4 = i1 + ((Bitmap)localObject2).getHeight();
      i2 = i3;
      i1 = i4;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mergeBitmaps() listViewHeight = ");
        ((StringBuilder)localObject2).append(i4);
        QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject2).toString());
        i2 = i3;
        i1 = i4;
      }
    }
    int i3 = this.w.getHeight();
    C();
    localObject1 = a(i2, i1, i3);
    C();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).setDensity(this.w.getDensity());
    a((Canvas)localObject2);
    i1 = ((Canvas)localObject2).save();
    float f1 = i3;
    ((Canvas)localObject2).translate(0.0F, f1);
    b((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i1);
    i1 = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, f1);
    c((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i1);
    d((Canvas)localObject2);
    ((Canvas)localObject2).setBitmap(null);
    return localObject1;
  }
  
  private void w()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      ((ChatXListView)localObject).setAdapter(null);
      localObject = this.a.aX().getWindow().getDecorView();
      if (!(localObject instanceof FrameLayout)) {
        return;
      }
      ((FrameLayout)localObject).removeView(this.r);
      this.r = null;
    }
  }
  
  private void x()
  {
    ArkAiAppCenter.b = this.q;
  }
  
  private void y()
  {
    this.q = ArkAiAppCenter.b;
    ArkAiAppCenter.b = true;
  }
  
  private void z()
  {
    List localList = MultiMsgManager.a().i();
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      MultiMsgManager.a().b(localList);
      this.b.addAll(localList);
    }
  }
  
  protected Bitmap a(Bitmap paramBitmap, View paramView, int paramInt)
  {
    if ((paramBitmap != null) && (paramView != null))
    {
      paramView.setDrawingCacheEnabled(true);
      Bitmap localBitmap1 = paramView.getDrawingCache();
      localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, paramInt, localBitmap1.getWidth(), localBitmap1.getHeight() - paramInt);
      paramView.setDrawingCacheEnabled(false);
      if (localBitmap1 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "createTitleBitmap: mTitleBitmap == null");
        return paramBitmap;
      }
      paramView = new Paint();
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, paramView);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paramView);
      return localBitmap2;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "clearCheckedItems() called");
    }
    this.b.clear();
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    paramLinearLayout.setGravity(16);
    this.h = new TextView(paramContext);
    this.h.setId(2131430540);
    this.h.setText(2131886535);
    this.h.setTextSize(1, 14.0F);
    this.h.setTextColor(this.a.e.getResources().getColorStateList(2131165456));
    int i1 = AIOUtils.b(12.0F, paramLinearLayout.getResources());
    this.h.setPadding(i1, 0, i1, 0);
    this.h.setGravity(17);
    Object localObject = new LinearLayout.LayoutParams(-2, -1);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.e)
    {
      localObject = this.h;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.h.setOnClickListener(new AIOLongShotHelper.7(this));
    paramLinearLayout.addView(this.h);
    this.i = new TextView(paramContext);
    this.i.setId(2131430537);
    this.i.setText(2131886533);
    this.i.setTextSize(1, 14.0F);
    this.i.setTextColor(this.a.e.getResources().getColorStateList(2131165456));
    this.i.setPadding(i1, 0, i1, 0);
    this.i.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.e)
    {
      localObject = this.i;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.i.setOnClickListener(new AIOLongShotHelper.8(this));
    paramLinearLayout.addView(this.i);
    this.j = new CheckBox(paramContext);
    this.j.setId(2131430539);
    this.j.setBackgroundDrawable(null);
    this.j.setButtonDrawable(2130838077);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.e)
    {
      localObject = this.j;
      ((CheckBox)localObject).setContentDescription(((CheckBox)localObject).getText());
    }
    this.j.setOnCheckedChangeListener(new AIOLongShotHelper.9(this));
    paramLinearLayout.addView(this.j);
    this.k = new TextView(paramContext);
    this.k.setId(2131430538);
    this.k.setText(2131886534);
    this.k.setTextSize(1, 14.0F);
    this.k.setTextColor(this.a.e.getResources().getColorStateList(2131165456));
    this.k.setPadding(AIOUtils.b(3.0F, paramContext.getResources()), 0, i1, 0);
    this.k.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.e)
    {
      localObject = this.k;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.k.setOnClickListener(new AIOLongShotHelper.10(this));
    paramLinearLayout.addView(this.k);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setId(2131430541);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    paramLinearLayout.addView((View)localObject);
    this.l = new Button(paramContext);
    this.l.setId(2131430536);
    this.l.setText(2131886532);
    this.l.setTextColor(this.a.e.getResources().getColorStateList(2131165456));
    this.l.setPadding(i1, 0, i1, 0);
    paramContext = this.l;
    paramContext.setTypeface(paramContext.getTypeface(), 1);
    this.l.setBackgroundResource(2130837935);
    if (AppSetting.e)
    {
      paramContext = this.l;
      paramContext.setContentDescription(paramContext.getText());
    }
    this.l.setOnClickListener(new AIOLongShotHelper.11(this));
    paramLinearLayout.addView(this.l);
  }
  
  public void a(View paramView)
  {
    a();
    z();
    MultiMsgManager.a().g();
    a(null, this.z);
    this.a.V.notifyDataSetChanged();
    k();
    if (this.a.ah.a == 1) {
      paramView = "2";
    } else if (this.a.ah.a == 0) {
      paramView = "1";
    } else {
      paramView = "0";
    }
    ReportController.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 3, 0, paramView, "", "", "");
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged() called with: message = [");
      ((StringBuilder)localObject).append(paramChatMessage);
      ((StringBuilder)localObject).append("], buttonView = [");
      ((StringBuilder)localObject).append(paramCompoundButton);
      ((StringBuilder)localObject).append("], isCheck = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramCompoundButton = this.a.U;
    paramCompoundButton = this.a.V;
    Object localObject = paramCompoundButton.a();
    if (paramChatMessage != null)
    {
      int i3 = ((List)localObject).indexOf(paramChatMessage);
      if (i3 < 0) {
        return;
      }
      if (paramBoolean)
      {
        localObject = new ArrayList(this.b.size());
        ((ArrayList)localObject).addAll(this.b);
        int i4 = a(i3);
        int i5 = b(i3);
        int i2 = -1;
        if (i4 >= 0) {
          i1 = i3 - i4;
        } else {
          i1 = -1;
        }
        if (i5 >= 0) {
          i2 = i5 - i3;
        }
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCheckedChanged() isCheck = [");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append("], left=[");
          localStringBuilder.append(i4);
          localStringBuilder.append("],leftDistance=[");
          localStringBuilder.append(i1);
          localStringBuilder.append("],position=[");
          localStringBuilder.append(i3);
          localStringBuilder.append("], rightCheckedPosition=[");
          localStringBuilder.append(i5);
          localStringBuilder.append("], rightDistance=[");
          localStringBuilder.append(i2);
          localStringBuilder.append("]");
          QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        }
        if (i1 > 0)
        {
          if (i2 > 0)
          {
            if (i1 <= i2) {
              a(i4, i3);
            } else {
              a(i3, i5);
            }
          }
          else {
            a(i4, i3);
          }
        }
        else if (i2 > 0) {
          a(i3, i5);
        }
        this.b.add(paramChatMessage);
        paramChatMessage = new Point();
        this.a.aX().getWindowManager().getDefaultDisplay().getSize(paramChatMessage);
        int i1 = B();
        i2 = j() + i1 + this.A;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCheckedChanged() totalHeight = ");
          localStringBuilder.append(i2);
          localStringBuilder.append(", title height = ");
          localStringBuilder.append(j());
          localStringBuilder.append(", input bar height = ");
          localStringBuilder.append(this.A);
          localStringBuilder.append(", 10 * outSize.y = [");
          localStringBuilder.append(paramChatMessage.y * 10);
          localStringBuilder.append("], outSize.x * outSize.y = [");
          localStringBuilder.append(paramChatMessage.x * paramChatMessage.y);
          localStringBuilder.append("]");
          QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        }
        if ((i2 > paramChatMessage.y * 10) || (i1 >= 30000) || (paramChatMessage.x * paramChatMessage.y >= 200000000))
        {
          this.b.clear();
          this.b.addAll((Collection)localObject);
          QQToast.makeText(this.a.e, HardCodeUtil.a(2131898364), 0).show();
        }
      }
      else
      {
        this.b.remove(paramChatMessage);
      }
      k();
      l();
      paramCompoundButton.notifyDataSetChanged();
      if (paramBoolean)
      {
        a("0X8009DEA");
        return;
      }
      a("0X8009DEB");
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return this.b.contains(paramChatMessage);
  }
  
  public void b()
  {
    if (!this.c) {
      return;
    }
    this.a.ba.removeView(this.o);
    a();
    Object localObject = this.C;
    if (localObject != null) {
      ((AIOLongShotHelper.MergeBitmapTask)localObject).a();
    }
    this.p.removeCallbacksAndMessages(null);
    this.a.U.a(false);
    this.a.a(false, null, false);
    k();
    this.c = false;
    a(null, false);
    w();
    localObject = this.a;
    if ((localObject instanceof BaseTroopChatPie))
    {
      localObject = (AIOShortcutBarHelper)((BaseChatPie)localObject).q(52);
      if (localObject != null) {
        ((AIOShortcutBarHelper)localObject).d(15);
      }
    }
  }
  
  public void b(View paramView)
  {
    a();
    this.a.V.notifyDataSetChanged();
    k();
    l();
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, null);
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:a	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4: getfield 1732	com/tencent/mobileqq/activity/aio/core/BaseChatPie:aZ	Landroid/view/ViewGroup;
    //   7: ldc_w 1733
    //   10: invokevirtual 1734	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +13 -> 28
    //   18: ldc 143
    //   20: iconst_1
    //   21: ldc_w 1736
    //   24: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: return
    //   28: aload_1
    //   29: iconst_1
    //   30: invokevirtual 952	android/view/View:setDrawingCacheEnabled	(Z)V
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 1738	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:i	(Landroid/view/View;)V
    //   38: aload_1
    //   39: iconst_0
    //   40: invokevirtual 952	android/view/View:setDrawingCacheEnabled	(Z)V
    //   43: return
    //   44: astore_2
    //   45: goto +36 -> 81
    //   48: astore_2
    //   49: ldc 143
    //   51: iconst_1
    //   52: ldc_w 1740
    //   55: aload_2
    //   56: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 1738	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:i	(Landroid/view/View;)V
    //   64: goto -26 -> 38
    //   67: astore_2
    //   68: ldc 143
    //   70: iconst_1
    //   71: ldc_w 1742
    //   74: aload_2
    //   75: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -40 -> 38
    //   81: aload_1
    //   82: iconst_0
    //   83: invokevirtual 952	android/view/View:setDrawingCacheEnabled	(Z)V
    //   86: goto +5 -> 91
    //   89: aload_2
    //   90: athrow
    //   91: goto -2 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AIOLongShotHelper
    //   13	69	1	localView	View
    //   44	1	2	localObject	Object
    //   48	8	2	localThrowable1	Throwable
    //   67	23	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   33	38	44	finally
    //   49	59	44	finally
    //   59	64	44	finally
    //   68	78	44	finally
    //   33	38	48	java/lang/Throwable
    //   59	64	67	java/lang/Throwable
  }
  
  public void g()
  {
    this.o = ((RelativeLayout)LayoutInflater.from(this.a.e).inflate(2131624113, this.a.ba, false));
    this.n = ((TextView)this.o.findViewById(2131437747));
    this.n.setOnClickListener(new AIOLongShotHelper.14(this));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.addRule(6, 2131445137);
    localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.a.e);
    this.o.setLayoutParams(localLayoutParams);
    this.a.ba.addView(this.o);
  }
  
  public String getTag()
  {
    return "AIOLongShotHelper";
  }
  
  public boolean h()
  {
    return (this.c) && (this.e);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18001)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          a(this.a.f, paramIntent);
        }
      }
      else if ((paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
        b();
      }
    }
    else if (paramInt1 == 18002)
    {
      if (paramInt2 == -1) {
        b();
      }
    }
    else if (paramInt1 == 18004)
    {
      if ((paramInt2 == -1) && (this.g))
      {
        this.g = false;
        b();
      }
    }
    else if (paramInt1 == 18003)
    {
      if (paramInt2 == -1) {
        b();
      }
    }
    else if ((paramInt1 == 100) && (paramInt2 == -1)) {
      b();
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      b();
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper
 * JD-Core Version:    0.7.0.1
 */