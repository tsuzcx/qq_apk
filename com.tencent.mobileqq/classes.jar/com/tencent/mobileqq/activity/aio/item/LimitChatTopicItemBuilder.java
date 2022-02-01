package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.extendfriend.utils.MatchChatAioVoicePlayerManager;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.limitchat.TopicTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LimitChatTopicItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  private HashSet<Long> a;
  
  public LimitChatTopicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(10);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<LimitChatTopicItemBuilder.Label> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = ViewUtils.b(12.0F);
    int k = ViewUtils.b(1.0F);
    int m = ViewUtils.b(8.0F);
    int n = ViewUtils.b(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(ViewUtils.b(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    LimitChatTopicItemBuilder.Label localLabel;
    if (i < i1)
    {
      localLabel = (LimitChatTopicItemBuilder.Label)paramList.get(i);
      if (TextUtils.isEmpty(localLabel.jdField_a_of_type_JavaLangCharSequence)) {
        break label307;
      }
      int i2 = (int)(((Paint)localObject).measureText(localLabel.jdField_a_of_type_JavaLangCharSequence.toString()) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localLabel);
        paramInt = paramInt - i2 - n;
      }
    }
    label307:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localLabel);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (LimitChatTopicItemBuilder.Label)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setParam(((LimitChatTopicItemBuilder.Label)localObject).jdField_a_of_type_Int, ((LimitChatTopicItemBuilder.Label)localObject).jdField_b_of_type_Int, j);
        paramList.setTextSize(12);
        paramList.setText(((LimitChatTopicItemBuilder.Label)localObject).jdField_a_of_type_JavaLangCharSequence);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
      }
      return localArrayList.size();
    }
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.a(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 1: 
    case 2: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698791);
    }
    if (paramInt2 == 10000) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698839);
    }
    if (paramInt2 > 1) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698784);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131698774);
  }
  
  @NotNull
  private String a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("matchTagId");
    if (paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {}
    for (int i = paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType;; i = 3)
    {
      paramJSONObject = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (ExtendFriendUserInfo.isTagIdFromSignalBomb(j)) {
        paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getString(2131698826);
      }
      for (;;)
      {
        paramTopicViewHolder.jdField_b_of_type_JavaLangString = paramJSONObject;
        return paramJSONObject;
        if (paramJSONObject.f()) {
          paramJSONObject = a(i, j);
        } else if (!paramJSONObject.f()) {
          paramJSONObject = b(i, j);
        } else {
          paramJSONObject = "";
        }
      }
    }
  }
  
  private String a(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, String paramString)
  {
    Object localObject;
    Bitmap localBitmap;
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof ChatAdapter1))
    {
      localObject = ((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a;
      if (localObject != null)
      {
        localBitmap = ((IFaceDecoder)localObject).getBitmapFromCacheFrom(1, paramString, 6);
        if (localBitmap == null)
        {
          if (((IFaceDecoder)localObject).isPausing()) {
            break label118;
          }
          ((IFaceDecoder)localObject).requestDecodeFace(paramString, 1, true);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = ImageUtil.c();
      }
      paramTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692212));
      return;
      paramString = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      continue;
      label118:
      paramString = null;
    }
  }
  
  private void a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, ArrayList<LimitChatTopicItemBuilder.Label> paramArrayList, JSONArray paramJSONArray)
  {
    int i = 0;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      paramArrayList.addAll(ExtendFriendLabelUtils.a(this.jdField_a_of_type_AndroidContentContext, paramJSONArray));
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      int j = ViewUtils.a() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298262) * 2 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298263) * 2;
      int k = a(j, paramTopicViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, paramArrayList);
      if (k > 0)
      {
        paramTopicViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (k < paramArrayList.size())
        {
          j = a(j, paramTopicViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout, paramArrayList.subList(k, paramArrayList.size()));
          paramTopicViewHolder = paramTopicViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
          if (j > 0) {}
          for (;;)
          {
            paramTopicViewHolder.setVisibility(i);
            return;
            i = 8;
          }
        }
        paramTopicViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      paramTopicViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramTopicViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramTopicViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("declaration");
    paramJSONObject = paramJSONObject.optString("signWords");
    if (!TextUtils.isEmpty(str))
    {
      paramTopicViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(str)), 3, 24));
      return;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramTopicViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(paramJSONObject)), 3, 24));
      return;
    }
    paramTopicViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
  }
  
  private void a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("shcoolInfos");
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      paramJSONObject = paramJSONObject.optJSONObject(0);
      if (paramJSONObject != null) {
        if (paramJSONObject.optLong("shcool_state") == 2L) {
          i = 1;
        }
      }
    }
    for (String str = paramJSONObject.optString("shcool_name");; str = null)
    {
      if (!TextUtils.isEmpty(paramString3)) {}
      for (paramJSONObject = paramString1 + " | " + paramString3;; paramJSONObject = paramString1)
      {
        if (paramInt >= 0)
        {
          paramString3 = SignalBombHelper.a(paramInt);
          label102:
          paramString1 = paramJSONObject;
          if (!TextUtils.isEmpty(paramString3)) {
            paramString1 = paramJSONObject + " | " + paramString3;
          }
          paramJSONObject = paramString1;
          if (!((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f())
          {
            paramJSONObject = paramString1;
            if (!TextUtils.isEmpty(paramString2)) {
              paramJSONObject = paramString1 + " | " + paramString2;
            }
          }
          paramTopicViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramJSONObject);
          paramJSONObject = paramTopicViewHolder.jdField_b_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label299;
          }
          paramInt = -1315851;
          label222:
          paramJSONObject.setTextColor(paramInt);
          if (TextUtils.isEmpty(str)) {
            break label323;
          }
          paramTopicViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str);
          paramJSONObject = paramTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView;
          if (i == 0) {
            break label307;
          }
          paramInt = 2130845301;
          label260:
          paramJSONObject.setImageResource(paramInt);
          paramTopicViewHolder = paramTopicViewHolder.jdField_c_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label315;
          }
        }
        label299:
        label307:
        label315:
        for (paramInt = -1315851;; paramInt = -7894119)
        {
          paramTopicViewHolder.setTextColor(paramInt);
          return;
          i = 0;
          break;
          paramString3 = null;
          break label102;
          paramInt = -7894119;
          break label222;
          paramInt = 2130845302;
          break label260;
        }
        label323:
        paramTopicViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      i = 0;
    }
  }
  
  private void a(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = paramTopicViewHolder.jdField_c_of_type_AndroidViewView;
    int i;
    if (paramBoolean2) {
      i = -14474461;
    }
    for (;;)
    {
      ((View)localObject).setBackgroundDrawable(a(16, i));
      localObject = new ArrayList();
      a(paramTopicViewHolder, paramString);
      a((ArrayList)localObject, paramJSONObject.optString("age"), paramJSONObject.optInt("gender"));
      if (!((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()) {
        a((ArrayList)localObject, paramJSONObject.optLong("popular"));
      }
      a(paramTopicViewHolder, paramJSONObject, paramBoolean2, a(paramTopicViewHolder, paramJSONObject), paramJSONObject.optString("city"), paramJSONObject.optString("constellation"), paramJSONObject.optInt("distance", -1));
      a(paramTopicViewHolder, (ArrayList)localObject, paramJSONObject.optJSONArray("personalTags"));
      a(paramTopicViewHolder, paramJSONObject);
      b(paramTopicViewHolder, paramJSONObject);
      b(paramTopicViewHolder, paramBoolean1, paramJSONObject, paramString, paramBoolean2, paramBoolean3);
      return;
      if (paramBoolean3) {
        i = -657670;
      } else {
        i = -1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  private void a(ArrayList<LimitChatTopicItemBuilder.Label> paramArrayList, long paramLong)
  {
    if (paramLong > 0L)
    {
      int i = ViewUtils.a(11.0F);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845249);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131693923);
      localObject1 = new SpannableString(str + " " + paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
      localObject2 = new LimitChatTopicItemBuilder.Label();
      ((LimitChatTopicItemBuilder.Label)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      ((LimitChatTopicItemBuilder.Label)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
      ((LimitChatTopicItemBuilder.Label)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
      paramArrayList.add(localObject2);
    }
  }
  
  private void a(ArrayList<LimitChatTopicItemBuilder.Label> paramArrayList, String paramString, int paramInt)
  {
    String str;
    label67:
    SpannableString localSpannableString;
    int i;
    label90:
    int j;
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (paramInt != 1) {
        break label192;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131693923);
      if (!((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()) {
        break label207;
      }
      paramString = str + " ";
      localSpannableString = new SpannableString(paramString);
      if (paramInt != 1) {
        break label266;
      }
      i = Color.parseColor("#3300CAFC");
      if (paramInt != 1) {
        break label277;
      }
      j = Color.parseColor("#02B2DD");
      label103:
      if (paramInt != 1) {
        break label288;
      }
    }
    label266:
    label277:
    label288:
    for (paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845248);; paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845247))
    {
      paramInt = ViewUtils.a(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new LimitChatTopicItemBuilder.Label();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      paramArrayList.add(paramString);
      return;
      label192:
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692330);
      break;
      label207:
      if (TextUtils.isEmpty(paramString))
      {
        paramString = str + " ";
        break label67;
      }
      paramString = str + " " + paramString;
      break label67;
      i = Color.parseColor("#33FF80BF");
      break label90;
      j = Color.parseColor("#FF80BF");
      break label103;
    }
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698711);
    case 2: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698714);
    }
    if (paramInt2 > 1) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131698784);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131698785);
  }
  
  private void b(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("voiceUrl");
    int i = paramJSONObject.optInt("voiceDuration");
    if (TextUtils.isEmpty(str)) {
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity));
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(str);
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      paramTopicViewHolder.jdField_a_of_type_JavaLangString = str;
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramTopicViewHolder);
      paramTopicViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
    } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramTopicViewHolder.jdField_a_of_type_Long)));
    a("", "0X800AA97", "", "");
  }
  
  private void b(LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramJSONObject = paramJSONObject.optString("topic_msg");
    int i;
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramJSONObject)))
    {
      paramTopicViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      Object localObject = paramTopicViewHolder.jdField_d_of_type_AndroidViewView;
      if (paramBoolean2)
      {
        i = -14474461;
        ((View)localObject).setBackgroundDrawable(a(16, i));
        localObject = paramTopicViewHolder.jdField_d_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label200;
        }
        i = -1712591883;
        label72:
        ((TextView)localObject).setTextColor(i);
        paramTopicViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        paramTopicViewHolder.jdField_c_of_type_JavaLangString = paramJSONObject;
        label92:
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramTopicViewHolder.jdField_a_of_type_Long)))
        {
          localObject = paramTopicViewHolder.jdField_b_of_type_JavaLangString;
          if (paramTopicViewHolder.jdField_b_of_type_Int != 1) {
            break label220;
          }
          paramJSONObject = (JSONObject)localObject;
          label126:
          a(paramString, "0X800AA94", (String)localObject, paramJSONObject);
        }
        paramString = paramTopicViewHolder.e;
        if (!paramBoolean2) {
          break label238;
        }
        paramJSONObject = a(20, 435549946);
      }
    }
    for (;;)
    {
      paramString.setBackgroundDrawable(paramJSONObject);
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramTopicViewHolder.jdField_a_of_type_Long));
      return;
      if (paramBoolean3)
      {
        i = -657670;
        break;
      }
      i = -1;
      break;
      label200:
      i = -7894119;
      break label72;
      paramTopicViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break label92;
      label220:
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramTopicViewHolder.jdField_b_of_type_JavaLangString;
        break label126;
      }
      break label126;
      label238:
      if (paramBoolean3) {
        paramJSONObject = a(20, -1);
      } else {
        paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839458);
      }
    }
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool4 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)paramMessageRecord;
    String str = localMessageForLimitChatTopic.getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramOnLongClickAndTouchListener = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramOnLongClickAndTouchListener;
      if ((paramViewHolder instanceof LimitChatTopicItemBuilder.TopicViewHolder)) {
        paramLinearLayout = (LimitChatTopicItemBuilder.TopicViewHolder)paramViewHolder;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label794;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559433, null);
      paramLinearLayout = new LimitChatTopicItemBuilder.TopicViewHolder();
      paramView.setTag(paramLinearLayout);
    }
    label788:
    label794:
    for (;;)
    {
      paramView.findViewById(2131371423).setVisibility(8);
      paramView.findViewById(2131371424).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131380651));
      paramLinearLayout.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363573);
      paramLinearLayout.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView.setTopicText(localMessageForLimitChatTopic.msg);
      paramLinearLayout.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (bool4) {}
      for (int i = Color.rgb(34, 34, 34);; i = -1)
      {
        paramMessageRecord = a(8, i);
        paramLinearLayout.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
        if (e)
        {
          paramViewHolder.b.append(localMessageForLimitChatTopic.msg);
          paramView.setContentDescription(paramViewHolder.b.toString());
        }
        return paramView;
      }
      try
      {
        paramOnLongClickAndTouchListener = new JSONObject(str);
        if (paramOnLongClickAndTouchListener == null) {
          return new View(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      catch (JSONException paramOnLongClickAndTouchListener)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramOnLongClickAndTouchListener, new Object[0]);
          paramOnLongClickAndTouchListener = null;
        }
        if ((paramViewHolder instanceof LimitChatTopicItemBuilder.TopicViewHolder)) {
          paramLinearLayout = (LimitChatTopicItemBuilder.TopicViewHolder)paramViewHolder;
        }
        if (paramView != null)
        {
          paramViewHolder = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559433, null);
          paramViewHolder = new LimitChatTopicItemBuilder.TopicViewHolder();
          paramView.setTag(paramViewHolder);
        }
        boolean bool3 = false;
        boolean bool2 = false;
        i = paramOnLongClickAndTouchListener.optInt("matchTagId");
        paramLinearLayout = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramMessageRecord.frienduin, false);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramLinearLayout;
        boolean bool1;
        if (i <= 1) {
          bool1 = false;
        }
        do
        {
          do
          {
            paramViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
            paramViewHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371423);
            paramViewHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371424);
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371080));
            paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369799));
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380579));
            paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380756));
            paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370027));
            paramViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370028));
            paramViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379695));
            paramViewHolder.e = ((TextView)paramView.findViewById(2131379694));
            paramViewHolder.e.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363206));
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131381739));
            paramViewHolder.e.setOnClickListener(this);
            paramViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
            paramViewHolder.jdField_b_of_type_Int = i;
            paramView.findViewById(2131363573).setVisibility(8);
            bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
            a(paramViewHolder, bool1, paramOnLongClickAndTouchListener, paramMessageRecord.frienduin, bool4, bool2);
            return paramView;
            bool1 = bool2;
          } while (paramLinearLayout == null);
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramLinearLayout.miniProfileMsg));
        bool2 = bool3;
        for (;;)
        {
          try
          {
            paramLinearLayout = new JSONObject(paramLinearLayout.miniProfileMsg);
            bool2 = bool3;
            if (paramLinearLayout.optBoolean("send_topic" + paramMessageRecord.uniseq, false)) {
              break label788;
            }
            bool1 = true;
            bool2 = bool1;
            paramViewHolder.jdField_a_of_type_OrgJsonJSONObject = paramLinearLayout;
          }
          catch (JSONException paramLinearLayout)
          {
            bool1 = bool2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("LimitChatTopicItemBuilder", 2, "" + paramLinearLayout);
          bool1 = bool2;
          break;
          bool1 = false;
        }
      }
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new LimitChatTopicItemBuilder.TopicViewHolder();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatTopicItemBuilder", 2, "destroy ");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    MatchChatAioVoicePlayerManager.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!(localObject1 instanceof LimitChatTopicItemBuilder.TopicViewHolder)) {
        continue;
      }
      localObject1 = (LimitChatTopicItemBuilder.TopicViewHolder)localObject1;
      if (((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_d_of_type_AndroidViewView == null) {
        continue;
      }
      ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
      Object localObject2 = ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject2 != null) {
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2);
      }
      if ((((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_OrgJsonJSONObject != null)) {}
      try
      {
        ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_OrgJsonJSONObject.put("send_topic" + ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_Long, true);
        ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.miniProfileMsg = ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_a_of_type_OrgJsonJSONObject.toString();
        label165:
        ThreadManager.getSubThreadHandler().post(new LimitChatTopicItemBuilder.1(this, (LimitChatTopicItemBuilder.TopicViewHolder)localObject1));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800AA95", ((LimitChatTopicItemBuilder.TopicViewHolder)localObject1).jdField_b_of_type_JavaLangString, (String)localObject2);
        continue;
        a("", "0X800AA96", "", "");
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 0, 2);
        continue;
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject1 instanceof LimitChatTopicItemBuilder.TopicViewHolder))) {
          continue;
        }
        Object localObject3 = (LimitChatTopicItemBuilder.TopicViewHolder)localObject1;
        localObject1 = (ExtendFriendVoiceView)paramView;
        if (((ExtendFriendVoiceView)localObject1).b())
        {
          ((ExtendFriendVoiceView)localObject1).d();
          MatchChatAioVoicePlayerManager.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        for (;;)
        {
          a("", "0X800AA98", "", "");
          break;
          if (!TextUtils.isEmpty(((LimitChatTopicItemBuilder.TopicViewHolder)localObject3).jdField_a_of_type_JavaLangString))
          {
            ((ExtendFriendVoiceView)localObject1).c();
            localObject2 = MatchChatAioVoicePlayerManager.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            ((MatchChatAioVoicePlayerManager)localObject2).a(((LimitChatTopicItemBuilder.TopicViewHolder)localObject3).jdField_a_of_type_JavaLangString);
            localObject3 = ((MatchChatAioVoicePlayerManager)localObject2).a();
            if ((localObject3 != null) && (localObject3 != localObject1) && (((ExtendFriendVoiceView)localObject3).b())) {
              ((ExtendFriendVoiceView)localObject3).d();
            }
            ((MatchChatAioVoicePlayerManager)localObject2).a((ExtendFriendVoiceView)localObject1);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        break label165;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LimitChatTopicItemBuilder
 * JD-Core Version:    0.7.0.1
 */