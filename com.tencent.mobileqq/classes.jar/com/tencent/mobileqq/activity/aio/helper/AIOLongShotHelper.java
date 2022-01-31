package com.tencent.mobileqq.activity.aio.helper;

import aciy;
import acka;
import ackc;
import acvs;
import acvt;
import acvu;
import acvv;
import acvw;
import acvx;
import acvy;
import acvz;
import acwa;
import acwb;
import acwc;
import acwd;
import acxg;
import acyp;
import adwz;
import aebg;
import aedo;
import aejb;
import ajjy;
import alck;
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
import android.support.v4.app.FragmentActivity;
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
import apto;
import arxu;
import awqx;
import baae;
import babr;
import bace;
import bafb;
import bbms;
import bbmy;
import begr;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.CommonTextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mnf;
import mqq.app.AppActivity;

public class AIOLongShotHelper
  implements acxg
{
  private int jdField_a_of_type_Int;
  private acka jdField_a_of_type_Acka;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AIOLongShotHelper.MergeBitmapTask jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
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
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  public AIOLongShotHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.a();
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
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin + paramView.getHeight() + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
    }
    return 0;
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
    int i = 0;
    for (int j = 0; ((Iterator)localObject1).hasNext(); j = k)
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
      i = ((Bitmap)localObject2).getHeight() + i;
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "mergeBitmaps() listViewHeight = " + i);
      }
    }
    int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    t();
    localObject1 = a(j, i, k);
    t();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).setDensity(this.jdField_a_of_type_AndroidGraphicsBitmap.getDensity());
    a((Canvas)localObject2);
    i = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, k);
    b((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    i = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, k);
    c((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    d((Canvas)localObject2);
    ((Canvas)localObject2).setBitmap(null);
    return localObject1;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    i = 0;
    try
    {
      int k = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      j = paramInt3 + paramInt2 + k;
      i = j;
      if (!QLog.isColorLevel()) {
        break label247;
      }
      i = j;
      QLog.d("AIOLongShotHelper", 2, "tryCreateBitmap() height = [" + j + "], inputBarBitmapHeight = [" + k + "], listViewHeight = [" + paramInt2 + "], titleBarHeight = [" + paramInt3 + "]");
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int j;
        Bitmap localBitmap1;
        QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 1 ", localThrowable1);
        Runtime.getRuntime().gc();
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.RGB_565);
          return localBitmap2;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 2 ", localThrowable2);
          Runtime.getRuntime().gc();
          try
          {
            Bitmap localBitmap3 = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.RGB_565);
            return localBitmap3;
          }
          catch (Throwable localThrowable3)
          {
            QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 3 ", localThrowable3);
            return null;
          }
        }
        if ((paramInt1 < 30000) && (j < 30000)) {
          if (paramInt1 * j < 200000000) {}
        }
      }
    }
    i = j;
    QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: size overflow. width = " + paramInt1 + ", height = " + j + ", w*h = " + paramInt1 * j);
    return null;
    i = j;
    localBitmap1 = Bitmap.createBitmap(paramInt1, j, Bitmap.Config.RGB_565);
    return localBitmap1;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: drawingCache == null");
      return null;
    }
    if (this.jdField_c_of_type_Int == -1) {}
    Object localObject;
    for (i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;; i = this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition())
    {
      if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())) {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: getFirstVisiblePosition=" + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() + ", mSelectionPosition=" + this.jdField_c_of_type_Int);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if (localObject != null) {
        break;
      }
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
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: invalid height mOverlapY=" + this.jdField_b_of_type_Int + ", getBottom = " + ((View)localObject).getBottom());
    }
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
      paramBitmap = (Bitmap)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", localThrowable);
        try
        {
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
        }
        catch (Throwable paramBitmap)
        {
          QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", paramBitmap);
          paramBitmap = null;
        }
      }
    }
    return paramBitmap;
  }
  
  private Drawable a()
  {
    return ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getParent()).getChildAt(0).getBackground();
  }
  
  public static AIOLongShotHelper a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)localObject).getChatFragment();
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
        QLog.d("AIOLongShotHelper", 2, "copy() called with: cm = [" + localChatMessage1 + "]");
        QLog.d("AIOLongShotHelper", 2, "copy() called with: copyChatMessage = [" + localChatMessage2 + "]");
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "regionCheck() called with: start = [" + paramInt1 + "], end = [" + paramInt2 + "]");
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.a();
    while ((paramInt1 >= 0) && (paramInt1 < localList.size()) && (paramInt1 < paramInt2))
    {
      this.jdField_a_of_type_JavaUtilSet.add(localList.get(paramInt1));
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
    }
    for (;;)
    {
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
      return;
      QLog.e("AIOLongShotHelper", 1, "sendPicToFriend: empty extras");
    }
  }
  
  private static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("forward_type", 1);
    localIntent.setData(Uri.parse(paramString));
    paramActivity.startActivityForResult(localIntent, 18001);
  }
  
  public static void a(Activity paramActivity, String paramString, acwd paramacwd)
  {
    begr localbegr = begr.c(paramActivity);
    localbegr.b(2131627742);
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramString))) {
      localbegr.b(2131627757);
    }
    localbegr.b(2131627752);
    localbegr.b(2131627740);
    localbegr.b(2131627272);
    localbegr.c(2131625035);
    localbegr.a(new acvy(paramActivity, localbegr, paramString, paramacwd));
    localbegr.show();
    a("0X8009DF0");
  }
  
  private void a(Context paramContext)
  {
    s();
    this.jdField_a_of_type_Bbms = new bbms(paramContext, paramContext.getResources().getDimensionPixelSize(2131167766));
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131634305));
    this.jdField_a_of_type_Bbms.show();
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      a(false, false, null);
      return;
    }
    QLog.d("AIOLongShotHelper", 1, "encodeAndWritePNG() called with: bitmap.bytes = [" + paramBitmap.getByteCount() / 1048576L + "MB], width=" + paramBitmap.getWidth() + ", height = " + paramBitmap.getHeight());
    String str = Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/aio_long_shot/";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (;;)
    {
      str = str + System.currentTimeMillis() + ".png";
      bace.a(paramBitmap, str, Bitmap.CompressFormat.PNG);
      paramBitmap.recycle();
      a(false, true, str);
      return;
      bace.b(str);
    }
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.notifyDataSetChanged();
  }
  
  private void a(ChatMessage paramChatMessage, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = true;
    k();
    if (paramBitmap == null) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(true);
    if (d())
    {
      a(false);
      h();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aebg))
    {
      paramChatMessage = (acyp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if (paramChatMessage != null) {
        paramChatMessage.b(false);
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aejb)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aedo))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public static void a(String paramString)
  {
    awqx.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = new ChatXListView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setClipChildren(false);
    this.jdField_a_of_type_Acka = new acka(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_Acka.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.a());
    this.jdField_a_of_type_Acka.a(paramList, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Acka);
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getSharedPreferences("AIOLongShotHelper", 0).edit().putBoolean("KEY_IS_FIRST_USE", paramBoolean).apply();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AIOLongShotHelper.1(this, paramBoolean1, paramBoolean2, paramString));
  }
  
  private boolean a(ViewGroup paramViewGroup)
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangReflectField == null) {
        this.jdField_a_of_type_JavaLangReflectField = ViewGroup.class.getDeclaredField("mGroupFlags");
      }
      this.jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      int i = this.jdField_a_of_type_JavaLangReflectField.getInt(paramViewGroup);
      return (i & 0x1) != 0;
    }
    catch (NoSuchFieldException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      return true;
    }
    catch (IllegalAccessException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    return true;
  }
  
  private int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ChatMessage)localIterator.next()).getViewHeight() + i) {}
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "getCheckedMessagesHeight() called height = " + i);
    }
    return i;
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.a();
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
      Object localObject;
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject = (MessageForArkBabyqReply)paramChatMessage;
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
      if ((paramChatMessage instanceof MessageForApollo))
      {
        localObject = ((MessageForApollo)paramChatMessage).mApolloGameArkMsg;
        if (localObject != null) {
          ((MessageForArkApp)localObject).arkContainer = null;
        }
      }
    }
    return paramChatMessage;
  }
  
  private static void b(Activity paramActivity, View paramView, int paramInt, begr parambegr, String paramString, acwd paramacwd)
  {
    if (paramView == null)
    {
      parambegr.dismiss();
      return;
    }
    String str = parambegr.a(paramInt);
    if (str == null)
    {
      parambegr.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      parambegr.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131627742)))
    {
      a(paramActivity, paramString);
      a("0X8009DF1");
    }
    for (;;)
    {
      parambegr.dismiss();
      return;
      if (str.equals(paramView.getResources().getString(2131627757)))
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
      else if (str.equals(paramView.getResources().getString(2131627752)))
      {
        paramActivity = new File(paramString);
        paramString = paramActivity.getAbsolutePath();
        adwz.a((Activity)paramView.getContext(), paramActivity, Utils.Crc64String(paramString));
        if (paramacwd != null) {
          paramacwd.a();
        }
        a("0X8009DF2");
      }
      else if (str.equals(paramView.getResources().getString(2131627740)))
      {
        if (paramacwd != null) {
          paramacwd.b();
        }
        paramActivity.runOnUiThread(new AIOLongShotHelper.4(paramString, paramActivity));
        a("0X8009DF3");
      }
      else if (str.equals(paramView.getResources().getString(2131627272)))
      {
        apto.a(paramActivity, paramString, 100);
        a("0X800A77C");
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    ackc localackc = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc;
    Object localObject;
    if (localackc != null)
    {
      localObject = localackc.a;
      boolean bool = mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("AIOLongShotHelper", 1, "drawBackground() called with: isAnonymous = [" + bool + "]");
      if (bool)
      {
        Drawable localDrawable = a();
        localObject = localDrawable;
        if (localDrawable == null)
        {
          QLog.e("AIOLongShotHelper", 1, "drawBackground: Anonymous bg == null");
          localObject = localackc.a;
        }
      }
      if (localObject != null) {
        break label189;
      }
      localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130848738);
    }
    label189:
    for (;;)
    {
      if (localObject == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawBackground: getDefaultThemeDrawable bg == null");
        return;
      }
      int i = paramCanvas.getHeight();
      paramCanvas.save();
      while (i > 0)
      {
        int j = ((Drawable)localObject).getBounds().height();
        i -= j;
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.translate(0.0F, j);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    paramView.setDrawingCacheEnabled(paramBoolean);
    paramView.destroyDrawingCache();
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        b(((ViewGroup)paramView).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "onGenerateFile() called with: path = [" + paramString + "]");
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      s();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      e(paramString);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      d(paramString);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      c(paramString);
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    int i = 0;
    int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
    if (j >= 0)
    {
      Bitmap localBitmap = (Bitmap)this.jdField_b_of_type_JavaUtilList.get(j);
      if (localBitmap == null) {
        QLog.e("AIOLongShotHelper", 1, "drawListView: mBitmapList.bm == null");
      }
      for (;;)
      {
        j -= 1;
        break;
        paramCanvas.drawBitmap(localBitmap, 0.0F, i, null);
        int k = localBitmap.getHeight();
        localBitmap.recycle();
        i += k;
      }
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
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString, new acvx(this));
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
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    localFragmentActivity.startActivityForResult(EditPicActivity.a(localFragmentActivity, paramString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null), 18003);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getSharedPreferences("AIOLongShotHelper", 0).getBoolean("KEY_IS_FIRST_USE", true);
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Int = 2;
    paramView.setEnabled(false);
    a(paramView.getContext());
    j();
  }
  
  private void e(String paramString)
  {
    if (paramString == null) {
      return;
    }
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    Intent localIntent = new Intent();
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    if ((localFragmentActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aciy.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(localFragmentActivity));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
        break label409;
      }
      if (!(localFragmentActivity instanceof SplashActivity)) {
        break label392;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = aciy.a(localIntent, null);
      label208:
      localIntent.putExtra(baae.h, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
      localIntent.setClass(localFragmentActivity, NewPhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("enter_from", 42);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(localFragmentActivity, NewPhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      localFragmentActivity.startActivityForResult(localIntent, 2);
      this.jdField_c_of_type_Boolean = true;
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label392:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label208;
      label409:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int);
    }
  }
  
  private boolean e()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_Acka.getItem(j + i);
      ChatMessage localChatMessage;
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        localChatMessage = a((ChatMessage)localObject);
        if (localChatMessage == null) {}
        do
        {
          return false;
          if (!((ChatMessage)localObject).mNeedTimeStamp) {
            break label135;
          }
          if (!localChatMessage.mNeedTimeStamp) {
            break;
          }
        } while (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight());
      }
      label135:
      label179:
      do
      {
        int k;
        do
        {
          do
          {
            i += 1;
            break;
            k = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131298583));
          } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight() + k);
          return false;
          if (!localChatMessage.mNeedTimeStamp) {
            break label179;
          }
          k = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131298583));
        } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight() - k);
        return false;
      } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight());
      return false;
    }
    return true;
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(bool);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
      return;
    }
  }
  
  private void f(View paramView)
  {
    this.jdField_a_of_type_Int = 1;
    paramView.setEnabled(false);
    a(paramView.getContext());
    j();
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
    }
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
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    int i = aciy.a(248.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources());
    int j = (int)(i * 420.0F / 472.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
    localObject = URLDrawable.getDrawable("http://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", (URLDrawable.URLDrawableOptions)localObject);
    localObject = babr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajjy.a(2131634303)).setMessage(ajjy.a(2131634307)).setPreviewImage((Drawable)localObject, true, 0).setPreviewFixDimension(i, j);
    ((bafb)localObject).setPositiveButton(ajjy.a(2131634308), new acvz(this));
    ((bafb)localObject).show();
  }
  
  private void h(View paramView)
  {
    paramView = paramView.getDrawingCache();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramView, 0, i, paramView.getWidth(), paramView.getHeight() - i);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      QLog.e("AIOLongShotHelper", 1, "createInputBarBitmap: mInputBarBitmap == null");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "createInputBarBitmap() mInputBarHeight = [" + this.jdField_d_of_type_Int + "]");
      }
      return;
      this.jdField_d_of_type_Int = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
    }
  }
  
  private void i()
  {
    if (d()) {
      ThreadManagerV2.executeOnSubThread(new AIOLongShotHelper.6(this));
    }
  }
  
  private void j()
  {
    Object localObject = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.a();
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
    q();
    o();
    a((List)localObject);
    l();
  }
  
  private void k()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_Acka = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new AIOLongShotHelper.13(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    int i = 150;
    List localList = this.jdField_a_of_type_Acka.a();
    int k = localList.size() - 1;
    for (;;)
    {
      int j = i;
      if (k >= 0)
      {
        j = i;
        if (k >= localList.size() - 1 - 10)
        {
          ChatMessage localChatMessage = (ChatMessage)localList.get(k);
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
          if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForApollo))) {
            break label205;
          }
          j = Math.max(750, i);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "scheduleSampleBitmap() called maxDelay = " + j);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, j);
      return;
      label205:
      k -= 1;
    }
  }
  
  private void m()
  {
    if ((!e()) && (this.jdField_e_of_type_Int < 3))
    {
      QLog.e("AIOLongShotHelper", 1, "sampleBitmap: not rendered now. Try again. mRetryRender = " + this.jdField_e_of_type_Int);
      l();
      this.jdField_e_of_type_Int += 1;
      return;
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawingCacheEnabled(true);
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getDrawingCache());
    this.jdField_b_of_type_JavaUtilList.add(localObject);
    b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((i == 0) && (((View)localObject).getTop() >= 0))
    {
      o();
      p();
      n();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask.a();
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
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "scheduleSampleBitmap() called y = " + this.jdField_b_of_type_Int + ", position = " + this.jdField_c_of_type_Int);
      }
      localObject = this.jdField_a_of_type_Acka.a();
      i = ((List)localObject).size() - 1;
      while (i > this.jdField_c_of_type_Int)
      {
        ((List)localObject).remove(i);
        i -= 1;
      }
      this.jdField_c_of_type_Int = i;
    }
    this.jdField_a_of_type_Acka.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_c_of_type_Int, -this.jdField_b_of_type_Int);
    l();
  }
  
  private void n()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (b())
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      d(localNavBarAIO);
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131311587);
    this.jdField_d_of_type_Boolean = true;
    localView.setVisibility(0);
    localNavBarAIO.setDrawingCacheEnabled(true);
    this.jdField_a_of_type_AndroidGraphicsBitmap = localNavBarAIO.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      QLog.e("AIOLongShotHelper", 1, "createTitleBitmap: mTitleBitmap == null");
    }
    localNavBarAIO.setDrawingCacheEnabled(false);
    localView.setVisibility(4);
    this.jdField_d_of_type_Boolean = false;
    if (b())
    {
      c(localNavBarAIO);
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void o()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      if ((localView instanceof FrameLayout)) {}
    }
    else
    {
      return;
    }
    ((FrameLayout)localView).removeView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
  }
  
  private void p()
  {
    alck.j = this.jdField_e_of_type_Boolean;
    BubbleVideoView.setDrawListener(null);
  }
  
  private void q()
  {
    this.jdField_e_of_type_Boolean = alck.j;
    alck.j = true;
    AIOBubbleVideoView.setOnVideoPreparedListener(new acvu(this));
  }
  
  private void r()
  {
    List localList = arxu.a().a();
    if ((localList == null) || (localList.isEmpty())) {
      return;
    }
    arxu.a().b(localList);
    this.jdField_a_of_type_JavaUtilSet.addAll(localList);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Bbms != null)
    {
      this.jdField_a_of_type_Bbms.dismiss();
      this.jdField_a_of_type_Bbms = null;
    }
  }
  
  private void t()
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1048576L;
    long l2 = localRuntime.maxMemory() / 1048576L;
    QLog.e("AIOLongShotHelper", 1, "printMemoryInfo: maxHeapSizeInMB=" + l2 + "MB, usedMemInMB=" + l1 + "MB, availHeapSizeInMB=" + (l2 - l1) + "MB");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "clearCheckedItems() called");
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      i();
      return;
    }
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        if (paramIntent != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent);
        }
      }
    }
    label27:
    do
    {
      do
      {
        do
        {
          do
          {
            break label27;
            break label27;
            do
            {
              return;
            } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
            b();
            return;
            if (paramInt1 != 18002) {
              break;
            }
          } while (paramInt2 != -1);
          b();
          return;
          if (paramInt1 != 2) {
            break;
          }
        } while ((paramInt2 != -1) || (!this.jdField_c_of_type_Boolean));
        this.jdField_c_of_type_Boolean = false;
        b();
        return;
        if (paramInt1 != 18003) {
          break;
        }
      } while (paramInt2 != -1);
      b();
      return;
    } while ((paramInt1 != 100) || (paramInt2 != -1));
    b();
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    paramLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131298515);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624399);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131099684));
    int i = aciy.a(12.0F, paramLinearLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    Object localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acwa(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131298512);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131624397);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131099684));
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new acwb(this));
    paramLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(paramContext);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131298514);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130837916);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(this.jdField_a_of_type_AndroidWidgetCheckBox.getText());
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new acwc(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetCheckBox);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131298513);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131624398);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131099684));
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(aciy.a(3.0F, paramContext.getResources()), 0, i, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new acvs(this));
    paramLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setId(2131298516);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    paramLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131298511);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131624396);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131099684));
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setTypeface(this.jdField_a_of_type_AndroidWidgetButton.getTypeface(), 1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837660);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getText());
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new acvt(this));
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  public void a(View paramView)
  {
    a();
    r();
    arxu.a().a();
    a(null, this.jdField_b_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.notifyDataSetChanged();
    f();
    paramView = "0";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      paramView = "2";
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 3, 0, paramView, "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        paramView = "1";
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, null);
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() called with: message = [" + paramChatMessage + "], buttonView = [" + paramCompoundButton + "], isCheck = [" + paramBoolean + "]");
    }
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka;
    Object localObject = paramCompoundButton.a();
    int k;
    if (paramChatMessage != null)
    {
      k = ((List)localObject).indexOf(paramChatMessage);
      if (k >= 0) {}
    }
    else
    {
      return;
    }
    int m;
    int n;
    if (paramBoolean)
    {
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilSet.size());
      ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilSet);
      m = a(k);
      n = b(k);
      if (m < 0) {
        break label610;
      }
    }
    label603:
    label610:
    for (int i = k - m;; i = -1)
    {
      if (n >= 0) {
        j = n - k;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() isCheck = [" + paramBoolean + "], left=[" + m + "],leftDistance=[" + i + "],position=[" + k + "], rightCheckedPosition=[" + n + "], rightDistance=[" + j + "]");
      }
      if (i > 0) {
        if (j > 0) {
          if (i <= j)
          {
            a(m, k);
            this.jdField_a_of_type_JavaUtilSet.add(paramChatMessage);
            paramChatMessage = new Point();
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindowManager().getDefaultDisplay().getSize(paramChatMessage);
            i = b();
            j = a() + i + this.jdField_d_of_type_Int;
            if (QLog.isColorLevel()) {
              QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() totalHeight = " + j + ", title height = " + a() + ", input bar height = " + this.jdField_d_of_type_Int + ", 10 * outSize.y = [" + paramChatMessage.y * 10 + "], outSize.x * outSize.y = [" + paramChatMessage.x * paramChatMessage.y + "]");
            }
            if ((j <= paramChatMessage.y * 10) && (i < 30000))
            {
              i = paramChatMessage.x;
              if (paramChatMessage.y * i < 200000000) {}
            }
            else
            {
              this.jdField_a_of_type_JavaUtilSet.clear();
              this.jdField_a_of_type_JavaUtilSet.addAll((Collection)localObject);
              bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, ajjy.a(2131634306), 0).a();
            }
          }
        }
      }
      for (;;)
      {
        f();
        g();
        paramCompoundButton.notifyDataSetChanged();
        if (!paramBoolean) {
          break label603;
        }
        a("0X8009DEA");
        return;
        a(k, n);
        break;
        a(m, k);
        break;
        if (j <= 0) {
          break;
        }
        a(k, n);
        break;
        this.jdField_a_of_type_JavaUtilSet.remove(paramChatMessage);
      }
      a("0X8009DEB");
      return;
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
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    acyp localacyp;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask.a();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        AIOBubbleVideoView.setOnVideoPreparedListener(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
        f();
        this.jdField_a_of_type_Boolean = false;
        a(null, false);
        o();
      } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aebg));
      localacyp = (acyp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
    } while (localacyp == null);
    localacyp.b(true);
  }
  
  public void b(View paramView)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acka.notifyDataSetChanged();
    f();
    g();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131298518);
    if (localView == null)
    {
      QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: chatContent == null, I'm in multi forward activity ?");
      return;
    }
    localView.setDrawingCacheEnabled(true);
    try
    {
      h(localView);
      return;
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: error. try again.", localThrowable1);
      try
      {
        h(localView);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: try failed", localThrowable2);
        }
      }
    }
    finally
    {
      localView.setDrawingCacheEnabled(false);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131309591);
    if (localView == null) {
      return;
    }
    ((ViewGroup)localView.getParent()).removeView(localView);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2131493007, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d, false));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303910));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new acvv(this));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131309736);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.findViewById(2131311534);
    if ((localObject instanceof CommonTextView))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d.findViewById(2131311587);
      ((CommonTextView)localObject).setOnVisibilityChangedListener(new acvw(this, localView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper
 * JD-Core Version:    0.7.0.1
 */