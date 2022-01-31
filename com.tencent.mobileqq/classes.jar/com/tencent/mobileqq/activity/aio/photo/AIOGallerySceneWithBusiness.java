package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
import vkp;
import vkq;

public class AIOGallerySceneWithBusiness
  extends AIOGalleryScene
{
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Button a;
  private AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  private Set jdField_a_of_type_JavaUtilSet;
  View b;
  public Button b;
  public Button c;
  Button jdField_d_of_type_AndroidWidgetButton;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  boolean t = false;
  
  public AIOGallerySceneWithBusiness(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel, paramIAIOImageProvider, paramString);
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.length >= 8)
      {
        j = 1;
        if (paramArrayOfString[7].equals("link")) {}
        do
        {
          return 3;
          i = j;
          if (paramArrayOfString.length < 9) {
            break;
          }
          i = j;
          if (!paramArrayOfString[7].equals("scrawl_link")) {
            break;
          }
          paramArrayOfString = paramArrayOfString[8];
          i = j;
          if (TextUtils.isEmpty(paramArrayOfString)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "name = " + paramArrayOfString + " , name.length = " + paramArrayOfString.length());
          }
          i = j;
          if (paramArrayOfString.startsWith("upload")) {
            break;
          }
        } while (paramArrayOfString.trim().length() <= 32);
        i = j;
      }
    }
    return i;
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof StructMsgForImageShare))) {
        return a((StructMsgForImageShare)paramChatMessage.structingMsg);
      }
    }
    return null;
  }
  
  public static String a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      if (!a(paramStructMsgForImageShare.mMsgActionData)) {
        break label70;
      }
      if ((TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)) || (paramStructMsgForImageShare.mMsg_A_ActionData.indexOf("|") <= 0)) {
        break label65;
      }
      localObject1 = "comic_plugin.apk|" + paramStructMsgForImageShare.mMsg_A_ActionData;
    }
    label65:
    label70:
    do
    {
      return localObject1;
      return paramStructMsgForImageShare.mMsgActionData;
      localObject1 = localObject2;
    } while (!b(paramStructMsgForImageShare.mMsgActionData));
    return paramStructMsgForImageShare.mMsgActionData;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8)
      {
        if (!paramString[7].equals("link")) {
          break label57;
        }
        str1 = paramString[4];
      }
    }
    label57:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (!paramString[7].equals("scrawl_link"));
      str1 = str2;
    } while (paramString.length < 9);
    return paramString[8];
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        y();
      }
      for (;;)
      {
        this.e.setText(paramString);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setDimAmount(0.0F);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        this.e = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog error " + paramContext.getMessage());
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("comic_plugin.apk"));
  }
  
  public static final String[] a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    int j = 1;
    String[] arrayOfString;
    if ((paramStructMsgForImageShare.mMsgActionData != null) && (paramStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
    {
      arrayOfString = paramStructMsgForImageShare.mMsgActionData.substring(paramStructMsgForImageShare.mMsgActionData.indexOf("|") + 1).split("\\|");
      if ((arrayOfString.length < 8) || ((!arrayOfString[7].equals("link")) && (!arrayOfString[7].equals("scrawl_link")))) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)))
      {
        paramStructMsgForImageShare = paramStructMsgForImageShare.mMsg_A_ActionData.split("\\|");
        if ((paramStructMsgForImageShare.length >= 8) && (paramStructMsgForImageShare[7].equals("link"))) {
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          return paramStructMsgForImageShare;
          i = 0;
        }
        else
        {
          return null;
          paramStructMsgForImageShare = arrayOfString;
        }
      }
    }
  }
  
  public static String[] a(String paramString)
  {
    if (a(paramString)) {
      return paramString.substring(paramString.indexOf("|") + 1).split("\\|");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8) {
        if (!paramString[7].equals("link"))
        {
          str1 = str2;
          if (!paramString[7].equals("scrawl_link")) {}
        }
        else
        {
          str1 = paramString[0];
        }
      }
    }
    return str1;
  }
  
  private void b(StructMsgForImageShare paramStructMsgForImageShare)
  {
    paramStructMsgForImageShare = b(paramStructMsgForImageShare.mMsgActionData);
    if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 2))
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare[1];
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("url", paramStructMsgForImageShare);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ScreenShotShare"));
  }
  
  public static String[] b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split("\\|");
    }
    return null;
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130971667, null);
    this.jdField_b_of_type_AndroidViewView.setClickable(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 72.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.addRule(12, -1);
    paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131375240));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131375241));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131375242));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375238));
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    paramViewGroup = new vkp(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewGroup);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(paramViewGroup);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramViewGroup);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    Object localObject2;
    Object localObject1;
    URLDrawable localURLDrawable;
    label66:
    do
    {
      return;
      localObject2 = paramStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label370;
      }
      if (((StructMsgItemImage)localObject2).a == null) {
        ((StructMsgItemImage)localObject2).a = paramStructMsgForImageShare;
      }
      localObject1 = ((StructMsgItemImage)localObject2).a();
      localURLDrawable = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, (MessageForPic)localObject1);
      if (!new File(((MessageForPic)localObject1).path).exists()) {
        break;
      }
      ((StructMsgItemImage)localObject2).u = ((MessageForPic)localObject1).path;
      if (!TextUtils.isEmpty(((StructMsgItemImage)localObject2).u)) {
        break label173;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
    return;
    String str = localURLDrawable.getURL().toString();
    if (AbsDownloader.a(str))
    {
      localObject1 = AbsDownloader.a(str);
      if (localObject1 == null) {
        break label420;
      }
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    for (;;)
    {
      ((StructMsgItemImage)localObject2).u = ((String)localObject1);
      break label66;
      localObject1 = URLDrawableHelper.a((PicUiInterface)localObject1, 65537);
      if (localObject1 != null)
      {
        localObject1 = AbsDownloader.a(((URL)localObject1).toString());
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          continue;
          label173:
          if (!AbsDownloader.a(localURLDrawable.getURL().toString())) {
            localURLDrawable.startDownload();
          }
          localObject1 = new Bundle();
          if ((paramStructMsgForImageShare.source_puin != null) && (!"".equals(paramStructMsgForImageShare.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramStructMsgForImageShare.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramStructMsgForImageShare.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramStructMsgForImageShare.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramStructMsgForImageShare.getBytes());
          localObject2 = new Intent();
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 0);
          localObject1 = a(paramStructMsgForImageShare);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          if (localObject1.length >= 8) {
            if (localObject1[7].equals("link")) {
              paramStructMsgForImageShare = localObject1[4];
            }
          }
          for (;;)
          {
            VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject1[0], new String[] { "1", "", paramStructMsgForImageShare });
            return;
            label370:
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
            return;
            if ((localObject1[7].equals("scrawl_link")) && (localObject1.length >= 9)) {
              paramStructMsgForImageShare = localObject1[8];
            } else {
              paramStructMsgForImageShare = "";
            }
          }
        }
      }
      label420:
      localObject1 = null;
    }
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    Object localObject2 = "";
    paramStructMsgForImageShare = a(paramStructMsgForImageShare);
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      localObject1 = localObject2;
      if (paramStructMsgForImageShare.length > 0) {
        localObject1 = paramStructMsgForImageShare[0];
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
      localJSONObject.put("leftViewText", "返回");
      localJSONObject.put("maintab", "index");
      ((Intent)localObject2).setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length >= 8))
      {
        if (paramStructMsgForImageShare[7].equals("link"))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[4];
          if (!"5".equals(paramString)) {
            break label248;
          }
          VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40057", localObject1, new String[] { "", "", paramStructMsgForImageShare });
        }
        label248:
        while (!"6".equals(paramString))
        {
          return;
          if ((!paramStructMsgForImageShare[7].equals("scrawl_link")) || (paramStructMsgForImageShare.length < 9)) {
            break label305;
          }
          paramStructMsgForImageShare = paramStructMsgForImageShare[8];
          break;
        }
        VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject1, new String[] { "4", "", paramStructMsgForImageShare });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label305:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!MediaCodecDPC.j()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a;
      if ((localObject instanceof AIOShortVideoData))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localObject;
        if (localAIOShortVideoData.j == 2)
        {
          if (this.jdField_d_of_type_AndroidWidgetButton != null) {
            return true;
          }
          if (localAIOShortVideoData.h == 0) {
            localObject = "好友排行榜";
          }
          for (;;)
          {
            this.jdField_d_of_type_AndroidWidgetButton = new Button(paramActivity);
            this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130845421);
            this.jdField_d_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
            this.jdField_d_of_type_AndroidWidgetButton.setTextColor(-1);
            this.jdField_d_of_type_AndroidWidgetButton.setTextSize(18.0F);
            int i = (int)(ViewUtils.a() * 0.42D);
            paramActivity = new RelativeLayout.LayoutParams(i, i * 114 / 314);
            paramActivity.addRule(14);
            paramActivity.addRule(12);
            paramActivity.bottomMargin = 56;
            paramViewGroup.addView(this.jdField_d_of_type_AndroidWidgetButton, paramActivity);
            this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(new vkq(this, localAIOShortVideoData));
            return true;
            if (1 == localAIOShortVideoData.h)
            {
              localObject = "查看群排名";
            }
            else
            {
              if (3000 != localAIOShortVideoData.h) {
                break;
              }
              localObject = "讨论组排名";
            }
          }
          return false;
        }
      }
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIORichMediaInfo == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.g == paramAIORichMediaInfo.a.g) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.f == paramAIORichMediaInfo.a.f)) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = paramAIORichMediaInfo;
      int j;
      Object localObject1;
      StructMsgForImageShare localStructMsgForImageShare2;
      String[] arrayOfString2;
      StructMsgForImageShare localStructMsgForImageShare1;
      String[] arrayOfString1;
      Object localObject2;
      if ((this.jdField_c_of_type_AndroidWidgetImageButton.getVisibility() != 4) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 4))
      {
        j = 1;
        if (AIOImageData.class.isInstance(paramAIORichMediaInfo.a))
        {
          localObject1 = (AIOImageData)paramAIORichMediaInfo.a;
          if (((AIOImageData)localObject1).c != 1) {
            break label565;
          }
          localStructMsgForImageShare2 = (StructMsgForImageShare)StructMsgFactory.a((byte[])((AIOImageData)localObject1).a);
          arrayOfString2 = a(localStructMsgForImageShare2);
          localStructMsgForImageShare1 = null;
          arrayOfString1 = null;
          localObject2 = arrayOfString1;
          localObject1 = localStructMsgForImageShare1;
          if (arrayOfString2 != null)
          {
            localObject2 = arrayOfString1;
            localObject1 = localStructMsgForImageShare1;
            if (arrayOfString2.length >= 8)
            {
              localObject1 = arrayOfString2[1];
              localObject2 = arrayOfString2[3] + "第" + arrayOfString2[5] + "页";
              if ((localObject1 == null) || (((String)localObject1).length() < 7)) {
                break label987;
              }
              localObject1 = ((String)localObject1).substring(0, 6) + "...";
            }
          }
        }
      }
      label389:
      label545:
      label565:
      label969:
      label987:
      for (;;)
      {
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramAIORichMediaInfo.hashCode())))
        {
          VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3008", "1", "30004", arrayOfString2[0], new String[] { arrayOfString2[2], arrayOfString2[4], a(localStructMsgForImageShare2.mMsgActionData) });
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramAIORichMediaInfo.hashCode()));
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          label372:
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label545;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText("该图片出自于：");
          }
          if ((arrayOfString2 != null) && (arrayOfString2.length >= 8) && (this.jdField_d_of_type_AndroidWidgetTextView != null)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          this.jdField_b_of_type_AndroidViewView.invalidate();
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare2);
          this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare2);
          this.jdField_c_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare2);
          if (j != 0)
          {
            this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          label488:
          if ((!a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidWidgetRelativeLayout)) || (!this.t)) {
            break label969;
          }
          this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
        }
        for (;;)
        {
          return true;
          j = 0;
          break;
          this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          break label372;
          this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          break label389;
          if (((AIOImageData)localObject1).c == 2)
          {
            localStructMsgForImageShare1 = (StructMsgForImageShare)StructMsgFactory.a((byte[])((AIOImageData)localObject1).a);
            arrayOfString1 = b(localStructMsgForImageShare1.mMsgActionData);
            if ((arrayOfString1 != null) && (arrayOfString1.length > 2))
            {
              localObject1 = arrayOfString1[2];
              paramAIORichMediaInfo = (AIORichMediaInfo)localObject1;
              if (localObject1 != null)
              {
                paramAIORichMediaInfo = (AIORichMediaInfo)localObject1;
                if (((String)localObject1).length() > 17) {
                  paramAIORichMediaInfo = ((String)localObject1).substring(0, 16) + "...";
                }
              }
              this.jdField_a_of_type_AndroidWidgetButton.setText(paramAIORichMediaInfo);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              if (i != 0)
              {
                paramAIORichMediaInfo = "";
                localObject1 = Uri.parse(arrayOfString1[1]);
              }
              try
              {
                localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                paramAIORichMediaInfo = (AIORichMediaInfo)localObject1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                }
              }
              localObject1 = paramAIORichMediaInfo;
              if (paramAIORichMediaInfo == null) {
                localObject1 = "";
              }
              paramAIORichMediaInfo = "";
              if (arrayOfString1.length > 3)
              {
                localObject2 = arrayOfString1[3];
                if (localObject2 != null)
                {
                  paramAIORichMediaInfo = (AIORichMediaInfo)localObject2;
                  if (((String)localObject2).equals("1")) {}
                }
                else
                {
                  paramAIORichMediaInfo = "";
                }
              }
              PublicAccountReportUtils.a(null, "", "0X8007153", "0X8007153", 0, 0, (String)localObject1, paramAIORichMediaInfo, "", "");
              PublicAccountReportUtils.a("0X8007153", "", (String)localObject1, paramAIORichMediaInfo, "", "");
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
              if (this.jdField_d_of_type_AndroidWidgetTextView != null)
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setText("截屏来自于：");
                if ((arrayOfString1 != null) && (arrayOfString1.length > 3))
                {
                  paramAIORichMediaInfo = arrayOfString1[3];
                  if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.equals("1"))) {
                    this.jdField_d_of_type_AndroidWidgetTextView.setText("图片来自于：");
                  }
                }
              }
              this.jdField_b_of_type_AndroidViewView.invalidate();
              this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare1);
              this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare1);
              this.jdField_c_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare1);
              if (j == 0) {
                break;
              }
              this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
              break;
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          if (j == 0) {
            break label488;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
          break label488;
          if (this.jdField_d_of_type_AndroidWidgetButton != null) {
            this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
          }
        }
      }
    }
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    if ((paramActionSheet == null) || (paramAIOImageData == null)) {}
    do
    {
      return false;
      if (paramAIOImageData.c == 1)
      {
        paramActionSheet.b(2131435854);
        paramActionSheet.b(2131435858);
        paramActionSheet.b(2131435875);
        paramActionSheet.b(2131435876);
        return true;
      }
    } while (paramAIOImageData.c != 2);
    paramActionSheet.b(2131435858);
    paramActionSheet.b(2131435854);
    paramActionSheet.b(2131435877);
    Object localObject = b(((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a)).mMsgActionData);
    if ((localObject != null) && (localObject.length > 2))
    {
      paramActionSheet = "";
      paramAIOImageData = Uri.parse(localObject[1]);
    }
    try
    {
      paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
      paramActionSheet = paramAIOImageData;
    }
    catch (Exception paramAIOImageData)
    {
      for (;;)
      {
        paramAIOImageData.printStackTrace();
      }
    }
    paramAIOImageData = paramActionSheet;
    if (paramActionSheet == null) {
      paramAIOImageData = "";
    }
    paramActionSheet = "";
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      if (localObject != null)
      {
        paramActionSheet = (ActionSheet)localObject;
        if (((String)localObject).equals("1")) {}
      }
      else
      {
        paramActionSheet = "";
      }
    }
    PublicAccountReportUtils.a(null, "", "0X8007154", "0X8007154", 0, 0, paramAIOImageData, paramActionSheet, "", "");
    return true;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    if ((paramString == null) || (paramAIOImageData == null) || (paramFile == null)) {}
    do
    {
      return false;
      if (!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131435854))) {
        break;
      }
    } while ((paramAIOImageData.c != 1) && (paramAIOImageData.c != 2));
    paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    a(paramString);
    if (paramAIOImageData.c == 2)
    {
      paramFile = b(paramString.mMsgActionData);
      if ((paramFile != null) && (paramFile.length > 2))
      {
        paramString = "";
        paramAIOImageData = Uri.parse(paramFile[1]);
      }
    }
    try
    {
      paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
      paramString = paramAIOImageData;
    }
    catch (Exception paramAIOImageData)
    {
      for (;;)
      {
        paramAIOImageData.printStackTrace();
      }
    }
    paramAIOImageData = paramString;
    if (paramString == null) {
      paramAIOImageData = "";
    }
    paramString = "";
    if (paramFile.length > 3)
    {
      paramFile = paramFile[3];
      if (paramFile != null)
      {
        paramString = paramFile;
        if (paramFile.equals("1")) {}
      }
      else
      {
        paramString = "";
      }
    }
    PublicAccountReportUtils.a(null, "", "0X8007131", "0X8007131", 0, 0, paramAIOImageData, paramString, "", "");
    return true;
    Object localObject;
    boolean bool;
    label284:
    String str1;
    if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131435858))) {
      if (paramAIOImageData.c == 1)
      {
        StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
        localObject = a(localStructMsgForImageShare);
        if ((localObject != null) && (localObject.length >= 8) && ((localObject[7].equals("link")) || (localObject[7].equals("scrawl_link"))))
        {
          bool = true;
          if (bool)
          {
            paramAIOImageData = null;
            paramString = paramAIOImageData;
            if (localObject[7].equals("scrawl_link"))
            {
              paramString = paramAIOImageData;
              if (localObject.length > 8) {
                paramString = localObject[8];
              }
            }
            String str2 = localObject[3] + "第" + localObject[5] + "页";
            str1 = "ADTAG=comic.plugin.read&id=" + localObject[0] + "&name=" + URLEncoder.encode(localObject[1]) + "&sectionID=" + localObject[2] + "&sectionName=" + URLEncoder.encode(localObject[3]) + "&pageID=" + localObject[4] + "&page=" + localObject[5] + "&type=" + localObject[6];
            paramAIOImageData = str1;
            if (!TextUtils.isEmpty(paramString)) {
              paramAIOImageData = str1 + "&scrawl_link=" + URLEncoder.encode(paramString);
            }
            paramString = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, paramAIOImageData);
            new QfavBuilder(6).a("nLinkType", 0).b("sTitle", localObject[1]).b("sUrl", paramString).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localStructMsgForImageShare.mSourceName).b("sBrief", str2).b("sPath", paramFile.getAbsolutePath()).b("sResUrl", localStructMsgForImageShare.mSourceUrl).a("lCategory", 1L).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
            QfavReport.a(null, 6, 2);
            if (localObject.length < 8) {
              break label1256;
            }
            if (!localObject[7].equals("link")) {
              break label718;
            }
            paramString = localObject[4];
          }
        }
      }
    }
    for (;;)
    {
      VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject[0], new String[] { "2", "", paramString });
      return bool;
      bool = false;
      break label284;
      label718:
      if ((localObject[7].equals("scrawl_link")) && (localObject.length >= 9))
      {
        paramString = localObject[8];
        continue;
        if (paramAIOImageData.c != 2) {
          break;
        }
        paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
        paramFile = b(paramString.mMsgActionData);
        if ((paramFile != null) && (paramFile.length > 2))
        {
          str1 = paramFile[1];
          paramAIOImageData = paramFile[2];
          paramAIOImageData = paramString.getFirstImageElement();
          if (paramAIOImageData != null)
          {
            if (paramAIOImageData.a == null) {
              paramAIOImageData.a = paramString;
            }
            localObject = AIOGalleryUtils.a(paramAIOImageData.a());
            paramAIOImageData = ((AIOImageData)localObject).a(4);
            paramString = paramAIOImageData;
            if (paramAIOImageData == null) {
              paramString = ((AIOImageData)localObject).a(2);
            }
            if (paramString != null) {
              paramString.getAbsolutePath();
            }
          }
          QfavBuilder.a(str1).c(this.jdField_b_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
          QfavReport.a(null, 6, 2);
          paramString = "";
          paramAIOImageData = Uri.parse(paramFile[1]);
          try
          {
            paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
            paramString = paramAIOImageData;
          }
          catch (Exception paramAIOImageData)
          {
            for (;;)
            {
              paramAIOImageData.printStackTrace();
            }
          }
          paramAIOImageData = paramString;
          if (paramString == null) {
            paramAIOImageData = "";
          }
          paramString = "";
          if (paramFile.length > 3)
          {
            paramFile = paramFile[3];
            if (paramFile != null)
            {
              paramString = paramFile;
              if (paramFile.equals("1")) {}
            }
            else
            {
              paramString = "";
            }
          }
          PublicAccountReportUtils.a(null, "", "0X8007132", "0X8007132", 0, 0, paramAIOImageData, paramString, "", "");
        }
        for (bool = true;; bool = false)
        {
          return bool;
          if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131435875)))
          {
            if (paramAIOImageData.c != 1) {
              break;
            }
            b((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
            return true;
          }
          if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131435876)))
          {
            if (paramAIOImageData.c != 1) {
              break;
            }
            a((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
            return true;
          }
          if ((!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131435877))) || (paramAIOImageData.c != 2)) {
            break;
          }
          paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
          b(paramString);
          paramFile = b(paramString.mMsgActionData);
          if ((paramFile != null) && (paramFile.length > 2))
          {
            paramString = "";
            paramAIOImageData = Uri.parse(paramFile[1]);
          }
          try
          {
            paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
            paramString = paramAIOImageData;
          }
          catch (Exception paramAIOImageData)
          {
            for (;;)
            {
              paramAIOImageData.printStackTrace();
            }
          }
          paramAIOImageData = paramString;
          if (paramString == null) {
            paramAIOImageData = "";
          }
          paramString = "";
          if (paramFile.length > 3)
          {
            paramFile = paramFile[3];
            if (paramFile != null)
            {
              paramString = paramFile;
              if (paramFile.equals("1")) {}
            }
            else
            {
              paramString = "";
            }
          }
          PublicAccountReportUtils.a(null, "", "0X8007130", "0X8007130", 0, 0, paramAIOImageData, paramString, "", "");
          return true;
        }
      }
      label1256:
      paramString = "";
    }
  }
  
  public void b(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {}
    for (;;)
    {
      return;
      paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
      JSONObject localJSONObject = new JSONObject();
      String str = VipComicJumpActivity.a("comicDetailComic", null, null, "1", "354", null, "ADTAG=comic.plugin.fav&pos=aio&id=" + arrayOfString[0]);
      try
      {
        localJSONObject.put("from", "13");
        localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicTabBrowserActivity");
        localJSONObject.put("url", URLEncoder.encode(str));
        localJSONObject.put("leftViewText", "返回");
        paramStructMsgForImageShare.setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
        if (arrayOfString.length >= 8)
        {
          if (arrayOfString[7].equals("link")) {}
          for (paramStructMsgForImageShare = arrayOfString[4]; "5".equals(paramString); paramStructMsgForImageShare = arrayOfString[8])
          {
            VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40055", arrayOfString[0], new String[] { "", "", paramStructMsgForImageShare });
            return;
            if ((!arrayOfString[7].equals("scrawl_link")) || (arrayOfString.length < 9)) {
              break label331;
            }
          }
          if (!"6".equals(paramString)) {
            continue;
          }
          VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", arrayOfString[0], new String[] { "3", "", paramStructMsgForImageShare });
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label331:
          paramStructMsgForImageShare = "";
        }
      }
    }
  }
  
  public void c(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {
      return;
    }
    int i = 1;
    paramString = new JSONObject();
    paramStructMsgForImageShare = new JSONObject();
    try
    {
      paramStructMsgForImageShare.put("comicID", arrayOfString[0]);
      paramStructMsgForImageShare.put("comicSectionID", arrayOfString[2]);
      paramStructMsgForImageShare.put("comicPageID", arrayOfString[4]);
      paramStructMsgForImageShare.put("type", arrayOfString[6]);
      paramString.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      paramString.put("comic", paramStructMsgForImageShare);
      paramString.put("from", "13");
      if (i != 0)
      {
        paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, VipComicJumpActivity.class);
        paramStructMsgForImageShare.putExtra("options", paramString.toString());
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
        paramString = "";
        if (arrayOfString.length < 8) {
          break label380;
        }
        paramStructMsgForImageShare = arrayOfString[4];
        if (!arrayOfString[7].equals("link")) {
          break label346;
        }
        paramString = arrayOfString[4];
        VipComicReportUtils.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40056", arrayOfString[0], new String[] { "", paramStructMsgForImageShare, paramString });
      }
    }
    catch (Exception paramStructMsgForImageShare)
    {
      for (;;)
      {
        i = 0;
        continue;
        paramString = "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html?_wv=5123&_bid=354&_cfrom=13&action=read&actionType=keepread&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&pageID=" + arrayOfString[4] + "&pageOffset=0&type=" + arrayOfString[6];
        paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        paramStructMsgForImageShare.putExtra("url", paramString);
        continue;
        label346:
        paramString = paramStructMsgForImageShare;
        if (arrayOfString[7].equals("scrawl_link"))
        {
          paramString = paramStructMsgForImageShare;
          if (arrayOfString.length >= 9)
          {
            paramString = arrayOfString[8];
            continue;
          }
        }
        label380:
        paramStructMsgForImageShare = paramString;
        paramString = "";
      }
    }
  }
  
  boolean g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      localObject = (AIOImageData)((AIORichMediaInfo)localObject).a;
      if ((((AIOImageData)localObject).c != 1) && (((AIOImageData)localObject).c != 2)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        if (this.jdField_d_of_type_AndroidWidgetButton != null) {
          this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
        }
        this.t = true;
        return true;
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  boolean h()
  {
    this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_d_of_type_AndroidWidgetButton != null) {
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
    }
    return true;
  }
  
  public void p()
  {
    super.p();
    y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness
 * JD-Core Version:    0.7.0.1
 */