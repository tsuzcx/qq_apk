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
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.ReflectionUtil;
import com.tencent.widget.ActionSheet;
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
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AIOLongShotHelper.MergeBitmapTask jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Field jdField_a_of_type_JavaLangReflectField;
  private List<ViewGroup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<ChatMessage> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<Bitmap> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public AIOLongShotHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    paramInt -= 1;
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.jdField_a_of_type_JavaUtilSet.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  private int a(View paramView)
  {
    int i = 0;
    if (paramView == null) {
      return 0;
    }
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      i = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramView.getHeight() + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return i;
  }
  
  private int a(ChatMessage paramChatMessage)
  {
    int j = paramChatMessage.getViewHeight();
    int i = j;
    if (j == 0) {
      i = b(paramChatMessage);
    }
    return i;
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mTitleBitmap == null");
      return null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mInputBarBitmap == null");
      return null;
    }
    Object localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Bitmap)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mBitmapList.bm == null");
        return null;
      }
      k = j;
      if (j == 0) {
        k = ((Bitmap)localObject2).getWidth();
      }
      int m = i + ((Bitmap)localObject2).getHeight();
      j = k;
      i = m;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mergeBitmaps() listViewHeight = ");
        ((StringBuilder)localObject2).append(m);
        QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject2).toString());
        j = k;
        i = m;
      }
    }
    int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    s();
    localObject1 = a(j, i, k);
    s();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).setDensity(this.jdField_a_of_type_AndroidGraphicsBitmap.getDensity());
    a((Canvas)localObject2);
    i = ((Canvas)localObject2).save();
    float f = k;
    ((Canvas)localObject2).translate(0.0F, f);
    b((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    i = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, f);
    c((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    d((Canvas)localObject2);
    ((Canvas)localObject2).setBitmap(null);
    return localObject1;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        i = paramInt3 + paramInt2 + j;
        try
        {
          if (!QLog.isColorLevel()) {
            break label288;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("tryCreateBitmap() height = [");
          localStringBuilder.append(i);
          localStringBuilder.append("], inputBarBitmapHeight = [");
          localStringBuilder.append(j);
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
          paramInt2 = i;
          break label211;
        }
        return Bitmap.createBitmap(paramInt1, i, Bitmap.Config.RGB_565);
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryCreateBitmap: size overflow. width = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", w*h = ");
      localStringBuilder.append(paramInt1 * i);
      QLog.e("AIOLongShotHelper", 1, localStringBuilder.toString());
      return null;
      label211:
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
      label288:
      if ((paramInt1 < 30000) && (i < 30000)) {
        if (paramInt1 * i < 200000000) {}
      }
    }
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: drawingCache == null");
      return null;
    }
    int i = this.jdField_c_of_type_Int;
    if (i == -1) {
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
    } else {
      i -= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    }
    if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCropBitmap: getFirstVisiblePosition=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(", mSelectionPosition=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.e("AIOLongShotHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
    if (localObject == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: selectedView == null");
      return null;
    }
    int j = ((View)localObject).getBottom() - this.jdField_b_of_type_Int;
    if (j <= paramBitmap.getHeight())
    {
      i = j;
      if (j > 0) {}
    }
    else
    {
      i = paramBitmap.getHeight();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCropBitmap: invalid height mOverlapY=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(", getBottom = ");
      localStringBuilder.append(((View)localObject).getBottom());
      QLog.e("AIOLongShotHelper", 1, localStringBuilder.toString());
    }
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", localThrowable);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", paramBitmap);
      }
    }
    return null;
  }
  
  private Drawable a()
  {
    return ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getParent()).getChildAt(0).getBackground();
  }
  
  public static AIOLongShotHelper a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof BaseActivity))
    {
      localObject = ((BaseActivity)localObject).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null)) {
        return (AIOLongShotHelper)((ChatFragment)localObject).a().a(15);
      }
    }
    return null;
  }
  
  private ChatMessage a(ChatMessage paramChatMessage)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (localChatMessage.uniseq == paramChatMessage.uniseq) {
        return localChatMessage;
      }
    }
    return null;
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
      ChatMessage localChatMessage2 = b(localChatMessage1);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    while ((paramInt1 >= 0) && (paramInt1 < ((List)localObject).size()) && (paramInt1 < paramInt2))
    {
      this.jdField_a_of_type_JavaUtilSet.add(((List)localObject).get(paramInt1));
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
    localIntent.putExtra("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", ((SessionInfo)localObject).b);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", ((SessionInfo)localObject).jdField_c_of_type_Int);
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
    localActionSheet.addButton(2131693256);
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramString))) {
      localActionSheet.addButton(2131693265);
    }
    localActionSheet.addButton(2131693262);
    localActionSheet.addButton(2131693254);
    localActionSheet.addButton(2131692771);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new AIOLongShotHelper.3(paramActivity, localActionSheet, paramString, paramOnActionSheetAction));
    localActionSheet.show();
    a("0X8009DF0");
  }
  
  private void a(Context paramContext)
  {
    r();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131299168));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131700323));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      localBitmap.recycle();
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void a(ChatMessage paramChatMessage, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = true;
    j();
    if (paramBitmap == null) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c(paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(true);
    if (d())
    {
      a(false);
      g();
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((paramChatMessage instanceof BaseTroopChatPie))
    {
      paramChatMessage = (AIOShortcutBarHelper)paramChatMessage.a(52);
      if (paramChatMessage != null) {
        paramChatMessage.c(16);
      }
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (((paramChatMessage instanceof TroopChatPie)) || ((paramChatMessage instanceof FriendChatPie))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = new ChatXListView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShouldPlayVideo(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramList, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView();
    if (!(paramList instanceof FrameLayout)) {
      return;
    }
    paramList = (FrameLayout)paramList;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(localLayoutParams);
    paramList.addView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getSharedPreferences("AIOLongShotHelper", 0).edit().putBoolean("KEY_IS_FIRST_USE", paramBoolean).apply();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AIOLongShotHelper.1(this, paramBoolean1, paramBoolean2, paramString));
  }
  
  private boolean a(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_JavaLangReflectField == null) {
        this.jdField_a_of_type_JavaLangReflectField = ReflectionUtil.a("android.view.View", "mGroupFlags");
      }
      this.jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      int i = this.jdField_a_of_type_JavaLangReflectField.getInt(paramViewGroup);
      if ((i & 0x1) != 0) {
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
  
  private int b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      i += a((ChatMessage)((Iterator)localObject).next());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCheckedMessagesHeight() called height = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.jdField_a_of_type_JavaUtilSet.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private int b(ChatMessage paramChatMessage)
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int m = localChatXListView.getChildCount();
    int k = 0;
    int i = 0;
    View localView;
    for (;;)
    {
      j = k;
      if (i >= m) {
        return j;
      }
      localView = localChatXListView.getChildAt(i);
      if ((localView != null) && (paramChatMessage.equals(localView.getTag(2131364534)))) {
        break;
      }
      i += 1;
    }
    int j = localView.getHeight();
    return j;
  }
  
  private ChatMessage b(ChatMessage paramChatMessage)
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
    if (str.equals(paramView.getResources().getString(2131693256)))
    {
      a(paramActivity, paramString);
      a("0X8009DF1");
    }
    else if (str.equals(paramView.getResources().getString(2131693265)))
    {
      a("0X800A502");
      if ((paramActivity instanceof SplashActivity))
      {
        paramView = ((AppActivity)paramActivity).getAppRuntime();
        if ((paramView instanceof QQAppInterface))
        {
          paramView = (QQAppInterface)paramView;
          PicShareToWX.a().a(paramActivity, paramView, paramString, 2);
        }
      }
      else
      {
        PicShareToWX.a(paramString, paramActivity, 2);
      }
    }
    else if (str.equals(paramView.getResources().getString(2131693262)))
    {
      paramActivity = new File(paramString);
      paramString = paramActivity.getAbsolutePath();
      com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils.a((Activity)paramView.getContext(), paramActivity, Utils.Crc64String(paramString));
      if (paramOnActionSheetAction != null) {
        paramOnActionSheetAction.a();
      }
      a("0X8009DF2");
    }
    else if (str.equals(paramView.getResources().getString(2131693254)))
    {
      if (paramOnActionSheetAction != null) {
        paramOnActionSheetAction.b();
      }
      paramActivity.runOnUiThread(new AIOLongShotHelper.4(paramString, paramActivity));
      a("0X8009DF3");
    }
    else if (str.equals(paramView.getResources().getString(2131692771)))
    {
      com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.a(paramActivity, paramString, 100);
      a("0X800A77C");
    }
    paramActionSheet.dismiss();
  }
  
  private void b(Canvas paramCanvas)
  {
    ChatBackground localChatBackground = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground;
    if (localChatBackground != null)
    {
      Object localObject1 = localChatBackground.a;
      boolean bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("drawBackground() called with: isAnonymous = [");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      QLog.d("AIOLongShotHelper", 1, ((StringBuilder)localObject2).toString());
      if (bool)
      {
        localObject2 = a();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          QLog.e("AIOLongShotHelper", 1, "drawBackground: Anonymous bg == null");
          localObject1 = localChatBackground.a;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850371);
      }
      if (localObject2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawBackground: getDefaultThemeDrawable bg == null");
        return;
      }
      int i = paramCanvas.getHeight();
      paramCanvas.save();
      while (i > 0)
      {
        int j = ((Drawable)localObject2).getBounds().height();
        i -= j;
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.translate(0.0F, j);
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
      int i = 0;
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        b(localViewGroup.getChildAt(i), paramBoolean);
        i += 1;
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
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          c(paramString);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        d(paramString);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      e(paramString);
    }
    r();
  }
  
  private void c(Canvas paramCanvas)
  {
    int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
    int j = 0;
    while (i >= 0)
    {
      Bitmap localBitmap = (Bitmap)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localBitmap == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawListView: mBitmapList.bm == null");
      }
      else
      {
        paramCanvas.drawBitmap(localBitmap, 0.0F, j, null);
        j += localBitmap.getHeight();
        localBitmap.recycle();
      }
      i -= 1;
    }
  }
  
  private void c(View paramView)
  {
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext()) {
      ((ViewGroup)paramView.next()).setClipChildren(false);
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, new AIOLongShotHelper.2(this));
  }
  
  private void d(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
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
        this.jdField_a_of_type_JavaUtilList.add(paramView);
      }
      paramView.setClipChildren(true);
      int i = 0;
      while (i < paramView.getChildCount())
      {
        d(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    localBaseActivity.startActivityForResult(((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(localBaseActivity, paramString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null), 18003);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getSharedPreferences("AIOLongShotHelper", 0).getBoolean("KEY_IS_FIRST_USE", true);
  }
  
  private void e()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty() ^ true;
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(bool);
    this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(bool);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Int = 2;
    paramView.setEnabled(false);
    a(paramView.getContext());
    i();
  }
  
  private void e(String paramString)
  {
    if (paramString == null) {
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    Intent localIntent = new Intent();
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
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
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    }
    localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
    localIntent.setClass(localBaseActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("enter_from", 42);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAioLongShot.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
    localIntent.setClass(localBaseActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    localBaseActivity.startActivityForResult(localIntent, 18004);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private boolean e()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(j + i);
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        ChatMessage localChatMessage = a((ChatMessage)localObject);
        if (localChatMessage == null) {
          return false;
        }
        int k;
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
            k = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131364552));
            if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight() + k) {
              return false;
            }
          }
        }
        else if (localChatMessage.mNeedTimeStamp)
        {
          k = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131364552));
          if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight() - k) {
            return false;
          }
        }
        else if (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight())
        {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private void f()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
    this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(bool ^ true);
  }
  
  private void f(View paramView)
  {
    this.jdField_a_of_type_Int = 1;
    paramView.setEnabled(false);
    a(paramView.getContext());
    i();
  }
  
  private void g()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    int i = AIOUtils.b(248.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources());
    int j = (int)(i * 420.0F / 472.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
    localObject = URLDrawable.getDrawable("https://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", (URLDrawable.URLDrawableOptions)localObject);
    localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 230).setTitle(HardCodeUtil.a(2131700321)).setMessage(HardCodeUtil.a(2131700325)).setPreviewImage((Drawable)localObject, true, 0).setPreviewFixDimension(i, j);
    ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131700326), new AIOLongShotHelper.5(this));
    ((QQCustomDialog)localObject).show();
  }
  
  private void g(View paramView)
  {
    this.jdField_a_of_type_Int = 0;
    paramView.setEnabled(false);
    a(paramView.getContext());
    this.jdField_a_of_type_AndroidOsHandler.post(new AIOLongShotHelper.12(this));
  }
  
  private void h()
  {
    if (d()) {
      ThreadManagerV2.executeOnNetWorkThread(new AIOLongShotHelper.6(this));
    }
  }
  
  private void h(View paramView)
  {
    paramView = paramView.getDrawingCache();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramView, 0, i, paramView.getWidth(), paramView.getHeight() - i);
    paramView = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (paramView == null) {
      QLog.e("AIOLongShotHelper", 1, "createInputBarBitmap: mInputBarBitmap == null");
    } else {
      this.jdField_d_of_type_Int = paramView.getHeight();
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("createInputBarBitmap() mInputBarHeight = [");
      paramView.append(this.jdField_d_of_type_Int);
      paramView.append("]");
      QLog.d("AIOLongShotHelper", 2, paramView.toString());
    }
  }
  
  private void i()
  {
    Object localObject = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i = 0;
    while (i < localList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if (this.jdField_a_of_type_JavaUtilSet.contains(localChatMessage)) {
        ((List)localObject).add(localChatMessage);
      }
      i += 1;
    }
    localObject = a((List)localObject);
    p();
    n();
    a((List)localObject);
    k();
  }
  
  private void j()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new AIOLongShotHelper.13(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    int i = 150;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int k = ((List)localObject).size() - 1;
    for (;;)
    {
      j = i;
      if (k < 0) {
        break label168;
      }
      j = i;
      if (k < ((List)localObject).size() - 1 - 10) {
        break label168;
      }
      ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(k);
      if (!(localChatMessage instanceof MessageForPic))
      {
        j = i;
        if (!(localChatMessage instanceof MessageForScribble)) {}
      }
      else
      {
        j = Math.max(250, i);
      }
      i = j;
      if ((localChatMessage instanceof MessageForShortVideo)) {
        i = Math.max(500, j);
      }
      if (((localChatMessage instanceof MessageForArkApp)) || ((localChatMessage instanceof IMessageForApollo))) {
        break;
      }
      k -= 1;
    }
    int j = Math.max(750, i);
    label168:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scheduleSampleBitmap() called maxDelay = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, j);
  }
  
  private void l()
  {
    if ((!e()) && (this.e < 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sampleBitmap: not rendered now. Try again. mRetryRender = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.e("AIOLongShotHelper", 1, ((StringBuilder)localObject).toString());
      k();
      this.e += 1;
      return;
    }
    this.e = 0;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawingCacheEnabled(true);
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getDrawingCache());
    this.jdField_b_of_type_JavaUtilList.add(localObject);
    b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((i == 0) && (((View)localObject).getTop() >= 0))
    {
      n();
      o();
      m();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask;
      if (localObject != null) {
        ((AIOLongShotHelper.MergeBitmapTask)localObject).a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask = new AIOLongShotHelper.MergeBitmapTask(this);
      ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask);
      return;
    }
    this.jdField_b_of_type_Int = (((View)localObject).getBottom() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getTop());
    if (this.jdField_b_of_type_Int == ((View)localObject).getHeight())
    {
      this.jdField_c_of_type_Int = (i - 1);
      this.jdField_b_of_type_Int = 0;
    }
    else
    {
      this.jdField_c_of_type_Int = i;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scheduleSampleBitmap() called y = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(", position = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("AIOLongShotHelper", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    i = ((List)localObject).size() - 1;
    while (i > this.jdField_c_of_type_Int)
    {
      ((List)localObject).remove(i);
      i -= 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_c_of_type_Int, -this.jdField_b_of_type_Int);
    k();
  }
  
  private void m()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (b())
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      d(localNavBarAIO);
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131378837);
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131378040);
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    localNavBarAIO.setDrawingCacheEnabled(true);
    this.jdField_a_of_type_AndroidGraphicsBitmap = localNavBarAIO.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      QLog.e("AIOLongShotHelper", 1, "createTitleBitmap: mTitleBitmap == null");
    }
    localNavBarAIO.setDrawingCacheEnabled(false);
    localView1.setVisibility(4);
    localView2.setVisibility(4);
    if (b())
    {
      c(localNavBarAIO);
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localObject != null)
    {
      ((ChatXListView)localObject).setAdapter(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView();
      if (!(localObject instanceof FrameLayout)) {
        return;
      }
      ((FrameLayout)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    }
  }
  
  private void o()
  {
    ArkAiAppCenter.jdField_b_of_type_Boolean = this.jdField_d_of_type_Boolean;
  }
  
  private void p()
  {
    this.jdField_d_of_type_Boolean = ArkAiAppCenter.jdField_b_of_type_Boolean;
    ArkAiAppCenter.jdField_b_of_type_Boolean = true;
  }
  
  private void q()
  {
    List localList = MultiMsgManager.a().a();
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      MultiMsgManager.a().b(localList);
      this.jdField_a_of_type_JavaUtilSet.addAll(localList);
    }
  }
  
  private void r()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void s()
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "clearCheckedItems() called");
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    paramLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364483);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689894);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165251));
    int i = AIOUtils.b(12.0F, paramLinearLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    Object localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AIOLongShotHelper.7(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131364480);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689892);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165251));
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AIOLongShotHelper.8(this));
    paramLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(paramContext);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131364482);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838035);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      ((CheckBox)localObject).setContentDescription(((CheckBox)localObject).getText());
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AIOLongShotHelper.9(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetCheckBox);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131364481);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689893);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165251));
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(3.0F, paramContext.getResources()), 0, i, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new AIOLongShotHelper.10(this));
    paramLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setId(2131364484);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    paramLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131364479);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131689891);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165251));
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(i, 0, i, 0);
    paramContext = this.jdField_a_of_type_AndroidWidgetButton;
    paramContext.setTypeface(paramContext.getTypeface(), 1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837911);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramContext = this.jdField_a_of_type_AndroidWidgetButton;
      paramContext.setContentDescription(paramContext.getText());
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new AIOLongShotHelper.11(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  public void a(View paramView)
  {
    a();
    q();
    MultiMsgManager.a().a();
    a(null, this.jdField_b_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      paramView = "2";
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      paramView = "1";
    } else {
      paramView = "0";
    }
    ReportController.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 3, 0, paramView, "", "", "");
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, null);
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
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    Object localObject = paramCompoundButton.a();
    if (paramChatMessage != null)
    {
      int k = ((List)localObject).indexOf(paramChatMessage);
      if (k < 0) {
        return;
      }
      if (paramBoolean)
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilSet.size());
        ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilSet);
        int m = a(k);
        int n = b(k);
        int j = -1;
        if (m >= 0) {
          i = k - m;
        } else {
          i = -1;
        }
        if (n >= 0) {
          j = n - k;
        }
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCheckedChanged() isCheck = [");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append("], left=[");
          localStringBuilder.append(m);
          localStringBuilder.append("],leftDistance=[");
          localStringBuilder.append(i);
          localStringBuilder.append("],position=[");
          localStringBuilder.append(k);
          localStringBuilder.append("], rightCheckedPosition=[");
          localStringBuilder.append(n);
          localStringBuilder.append("], rightDistance=[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        }
        if (i > 0)
        {
          if (j > 0)
          {
            if (i <= j) {
              a(m, k);
            } else {
              a(k, n);
            }
          }
          else {
            a(m, k);
          }
        }
        else if (j > 0) {
          a(k, n);
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramChatMessage);
        paramChatMessage = new Point();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindowManager().getDefaultDisplay().getSize(paramChatMessage);
        int i = b();
        j = a() + i + this.jdField_d_of_type_Int;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCheckedChanged() totalHeight = ");
          localStringBuilder.append(j);
          localStringBuilder.append(", title height = ");
          localStringBuilder.append(a());
          localStringBuilder.append(", input bar height = ");
          localStringBuilder.append(this.jdField_d_of_type_Int);
          localStringBuilder.append(", 10 * outSize.y = [");
          localStringBuilder.append(paramChatMessage.y * 10);
          localStringBuilder.append("], outSize.x * outSize.y = [");
          localStringBuilder.append(paramChatMessage.x * paramChatMessage.y);
          localStringBuilder.append("]");
          QLog.d("AIOLongShotHelper", 2, localStringBuilder.toString());
        }
        if ((j > paramChatMessage.y * 10) || (i >= 30000) || (paramChatMessage.x * paramChatMessage.y >= 200000000))
        {
          this.jdField_a_of_type_JavaUtilSet.clear();
          this.jdField_a_of_type_JavaUtilSet.addAll((Collection)localObject);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131700324), 0).a();
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilSet.remove(paramChatMessage);
      }
      e();
      f();
      paramCompoundButton.notifyDataSetChanged();
      if (paramBoolean)
      {
        a("0X8009DEA");
        return;
      }
      a("0X8009DEB");
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramChatMessage);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask;
    if (localObject != null) {
      ((AIOLongShotHelper.MergeBitmapTask)localObject).a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false, null, false);
    e();
    this.jdField_a_of_type_Boolean = false;
    a(null, false);
    n();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof BaseTroopChatPie))
    {
      localObject = (AIOShortcutBarHelper)((BaseChatPie)localObject).a(52);
      if (localObject != null) {
        ((AIOShortcutBarHelper)localObject).c(15);
      }
    }
  }
  
  public void b(View paramView)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    e();
    f();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   4: getfield 1687	com/tencent/mobileqq/activity/aio/core/BaseChatPie:c	Landroid/view/ViewGroup;
    //   7: ldc_w 1688
    //   10: invokevirtual 1689	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +13 -> 28
    //   18: ldc 138
    //   20: iconst_1
    //   21: ldc_w 1691
    //   24: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: return
    //   28: aload_1
    //   29: iconst_1
    //   30: invokevirtual 1046	android/view/View:setDrawingCacheEnabled	(Z)V
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 1693	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:h	(Landroid/view/View;)V
    //   38: aload_1
    //   39: iconst_0
    //   40: invokevirtual 1046	android/view/View:setDrawingCacheEnabled	(Z)V
    //   43: return
    //   44: astore_2
    //   45: goto +36 -> 81
    //   48: astore_2
    //   49: ldc 138
    //   51: iconst_1
    //   52: ldc_w 1695
    //   55: aload_2
    //   56: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 1693	com/tencent/mobileqq/activity/aio/helper/AIOLongShotHelper:h	(Landroid/view/View;)V
    //   64: goto -26 -> 38
    //   67: astore_2
    //   68: ldc 138
    //   70: iconst_1
    //   71: ldc_w 1697
    //   74: aload_2
    //   75: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -40 -> 38
    //   81: aload_1
    //   82: iconst_0
    //   83: invokevirtual 1046	android/view/View:setDrawingCacheEnabled	(Z)V
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
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131558556, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d, false));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370475));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new AIOLongShotHelper.14(this));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.addRule(6, 2131376809);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public String getTag()
  {
    return "AIOLongShotHelper";
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
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
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
      if ((paramInt2 == -1) && (this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = false;
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
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper
 * JD-Core Version:    0.7.0.1
 */