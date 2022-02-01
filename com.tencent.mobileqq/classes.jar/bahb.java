import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.2;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleBoarderImageView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;

public class bahb
  extends badd
  implements View.OnClickListener, aoog, bbwi, blih
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyu jdField_a_of_type_Anyu = new bahc(this);
  private aoof jdField_a_of_type_Aoof;
  private bahh jdField_a_of_type_Bahh;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public bahb(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a(RichStatus paramRichStatus, View paramView)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramRichStatus != null)
    {
      if (paramRichStatus.actionText != null) {
        localStringBuilder.append(paramRichStatus.actionText);
      }
      if (paramRichStatus.dataText != null) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      int i;
      if (paramRichStatus.topics != null)
      {
        i = 0;
        if (i < paramRichStatus.topics.size())
        {
          if (TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(i)).second)) {}
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append((String)((Pair)paramRichStatus.topics.get(i)).second);
          }
        }
      }
      if (paramRichStatus.plainText != null) {
        i = paramRichStatus.plainText.size();
      }
      while (j < i)
      {
        String str = (String)paramRichStatus.plainText.get(j);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str);
        }
        j += 1;
        continue;
        i = 0;
      }
    }
    paramView.setContentDescription(anzj.a(2131707359) + localStringBuilder);
  }
  
  private void a(RichStatus paramRichStatus, bbvd parambbvd)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if ((this.jdField_a_of_type_Bahh == null) && (parambbvd != null))
      {
        this.jdField_a_of_type_Bahh = new bahh(this);
        parambbvd.a(this.jdField_a_of_type_Bahh);
      }
    }
    do
    {
      return;
      ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    } while ((this.jdField_a_of_type_Bahh == null) || (parambbvd == null));
    parambbvd.b(this.jdField_a_of_type_Bahh);
    this.jdField_a_of_type_Bahh = null;
  }
  
  private void a(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Aoof != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramString, 1, true);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bhmq.a();
    }
    paramString = new BitmapDrawable(paramString);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    paramCircleBoarderImageView.setImageDrawable(paramString);
  }
  
  private void a(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, View paramView, TextView paramTextView, LinearLayout paramLinearLayout)
  {
    int i;
    if (paramSpannableString.length() >= 0) {
      if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
      {
        if (!paramBoolean) {
          break label464;
        }
        i = 1;
      }
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i, 0, "" + i, "0", "", "");
      label152:
      label204:
      label235:
      boolean bool1;
      if ((!azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.jdField_a_of_type_Boolean))
      {
        if ((paramRichStatus.plainText != null) && (paramRichStatus.plainText.size() > 0))
        {
          paramSpannableString = (String)paramRichStatus.plainText.get(0);
          this.c = paramSpannableString;
          paramRichStatus.sortTopicPos();
          if ((paramRichStatus.topicsPos == null) || (paramRichStatus.topicsPos.size() <= 0)) {
            break label475;
          }
          i = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
          this.jdField_a_of_type_Int = i;
          if (!ProfileCardMoreInfoView.a(paramTextView)) {
            break label481;
          }
          paramTextView.post(new ProfileContentSignComponent.3(this, paramTextView, paramRichStatus));
        }
      }
      else
      {
        azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
        bool1 = azyk.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramRichStatus = (ImageView)paramView.findViewById(2131379053);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null) || (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
          break label554;
        }
      }
      try
      {
        paramSpannableString.mergeFrom(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramSpannableString = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramSpannableString != null) {}
        for (paramSpannableString = paramSpannableString.rpt_topic_item.get();; paramSpannableString = null)
        {
          long l = azyk.a().a(paramSpannableString);
          boolean bool2 = azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
          if ((!bool1) && (!bool2)) {
            break label546;
          }
          i = azyk.a().a(paramSpannableString);
          if ((paramSpannableString == null) || (paramSpannableString.size() <= 0) || (i <= 0)) {
            break label526;
          }
          paramLinearLayout.setTag(new azvr(97, azyk.a().a(paramSpannableString)));
          paramLinearLayout.setOnClickListener(this);
          a(paramLinearLayout, paramSpannableString);
          paramRichStatus.setOnTouchListener(mvd.a);
          paramRichStatus.setOnClickListener(new bahd(this, paramLinearLayout));
          return;
          label464:
          i = 2;
          break;
          paramSpannableString = null;
          break label152;
          label475:
          i = 0;
          break label204;
          label481:
          this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
          this.jdField_a_of_type_JavaLangString = ((String)((Pair)paramRichStatus.topics.get(0)).second);
          this.jdField_b_of_type_JavaLangString = paramRichStatus.actionText;
          break label235;
        }
        label526:
        a(paramLinearLayout, paramBoolean);
        return;
      }
      catch (Exception paramSpannableString)
      {
        QLog.e("ProfileContentSignComponent", 1, "", paramSpannableString);
        return;
      }
    }
    label546:
    a(paramLinearLayout, paramBoolean);
    return;
    label554:
    a(paramLinearLayout, paramBoolean);
  }
  
  private void a(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, TextView paramTextView, LinearLayout paramLinearLayout, bbvd parambbvd)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      paramLinearLayout = new SpannableStringBuilder(paramSpannableString);
      paramLinearLayout.insert(0, "[S] ");
      if (parambbvd != null) {}
      for (paramSpannableString = parambbvd.a(paramRichStatus.actionId, 200);; paramSpannableString = bhgm.a(localResources, 2130849586))
      {
        int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramSpannableString = new bjdm(localResources, paramSpannableString, false, false);
        paramSpannableString.setBounds(0, 0, i, i);
        paramSpannableString = new bizo(paramSpannableString, 0);
        paramSpannableString.a(-0.1F);
        paramLinearLayout.setSpan(paramSpannableString, 0, "[S]".length(), 17);
        this.jdField_b_of_type_Int = i;
        paramTextView.setText(new begp(paramLinearLayout, 1, 20));
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
    }
    this.jdField_b_of_type_Int = 0;
    if ((paramSpannableString.length() == 0) && (paramBoolean))
    {
      paramTextView.setText(2131698338);
      a(paramLinearLayout, paramBoolean);
      return;
    }
    paramTextView.setText(new begp(paramSpannableString, 1, 20));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong)
  {
    int i;
    EntityManager localEntityManager;
    Object localObject;
    if (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i != 0)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject != null) {
          break label149;
        }
        localObject = null;
        label58:
        if (localObject != null) {
          break label172;
        }
        localObject = new Card();
        ((Card)localObject).uin = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        ((Card)localObject).vRichSign = paramArrayOfByte;
        ((Card)localObject).lSignModifyTime = paramLong;
        localEntityManager.persist((Entity)localObject);
      }
    }
    for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = (byte[])localObject)
    {
      ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfByte.getRichStatus();
      a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      return;
      i = 0;
      break;
      label149:
      localObject = ((anyw)localObject).b(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break label58;
      label172:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.update((Entity)localObject);
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool;
    Object localObject1;
    int i;
    int j;
    label74:
    Object localObject2;
    if (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      paramBoolean = true;
      bool = ProfileActivity.AllInOne.g(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (!bafb.a((azxr)this.jdField_b_of_type_JavaLangObject)) {
        break label235;
      }
      i = ((Resources)localObject1).getColor(2131166990);
      j = ((Resources)localObject1).getColor(2131166990);
      localObject2 = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramCard != null) {
          localObject1 = paramCard.getRichStatus();
        }
      }
      if (localObject1 == null) {
        break label511;
      }
    }
    label235:
    label509:
    label511:
    for (paramCard = new SpannableString(((RichStatus)localObject1).toSpannableStringWithTopic(null, i, j, this));; paramCard = null)
    {
      localObject2 = paramCard;
      if (paramCard == null) {
        localObject2 = new SpannableString("");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileContentSignComponent", 2, String.format("makeOrRefreshSign isHost=%s isPaTypeHasUin=%s length=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(((SpannableString)localObject2).length()) }));
      }
      if ((!paramBoolean) && ((!bool) || (((SpannableString)localObject2).length() == 0)))
      {
        if (this.jdField_a_of_type_JavaLangObject == null) {
          break label509;
        }
        this.jdField_a_of_type_JavaLangObject = null;
        return true;
        paramBoolean = false;
        break;
        j = ((Resources)localObject1).getColor(2131165343);
        i = -8947849;
        break label74;
      }
      Object localObject3;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        localObject3 = this.jdField_a_of_type_Baiy.a(a_());
        paramCard = (Card)localObject3;
        if (localObject3 == null) {
          paramCard = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561475, null);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
      }
      for (bool = true;; bool = false)
      {
        View localView = (View)this.jdField_a_of_type_JavaLangObject;
        paramCard = localView.findViewById(2131374416);
        localObject3 = (TextView)localView.findViewById(2131368636);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131370249);
        ((TextView)localObject3).setTextColor(i);
        bbvd localbbvd = (bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
        a(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, (TextView)localObject3, localLinearLayout, localbbvd);
        a(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, localView, (TextView)localObject3, localLinearLayout);
        a((RichStatus)localObject1, paramCard);
        a((RichStatus)localObject1, localbbvd);
        localObject1 = (ImageView)localView.findViewById(2131362954);
        if ((paramBoolean) || (ProfileActivity.AllInOne.b(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          ((ImageView)localObject1).setVisibility(0);
          paramCard.setTag(new azvr(3, null));
          paramCard.setOnClickListener(this);
        }
        while (paramBoolean)
        {
          a(null, (View)localObject1);
          return bool;
          ((ImageView)localObject1).setVisibility(4);
        }
        a((TextView)localObject3, (View)localObject1);
        return bool;
      }
      return false;
    }
  }
  
  public int a()
  {
    return 1011;
  }
  
  public String a()
  {
    return "ProfileContentSignComponent";
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = (RelativeLayout)paramView.findViewById(2131366726);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      localObject = (CircleBoarderImageView)paramView.findViewById(2131364542);
      CircleBoarderImageView localCircleBoarderImageView = (CircleBoarderImageView)paramView.findViewById(2131364543);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131364544);
      if (localObject != null) {
        ((CircleBoarderImageView)localObject).setVisibility(8);
      }
      if (localCircleBoarderImageView != null) {
        localCircleBoarderImageView.setVisibility(8);
      }
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView, List<oidb_0xd9f.TopicItem> paramList)
  {
    if (paramView != null)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        paramView.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramView.setVisibility(0);
    ((RelativeLayout)paramView.findViewById(2131366726)).setVisibility(0);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131364542);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364543);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364544);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131379758);
    Collections.sort(paramList, new bahe(this));
    int j = azyk.a().a(paramList);
    paramList = azyk.a().a(paramList);
    if (paramList.size() > localArrayList.size())
    {
      i = 0;
      while (i < localArrayList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
        i += 1;
      }
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      if (i < paramList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        a(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(8);
      }
    }
    if (j <= 3)
    {
      paramList = j + anzj.a(2131707356);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label461;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = anzj.a(2131707326) + j + anzj.a(2131707305);
      break;
      label461:
      if (!bafb.a((azxr)this.jdField_b_of_type_JavaLangObject)) {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845858));
      } else {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845857));
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (!paramBoolean) {
        paramView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (!azyk.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = arpj.a();
    if ((localObject == null) || (((arpg)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    a(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((arpg)localObject).a().a;
    TextView localTextView = (TextView)paramView.findViewById(2131379758);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379053);
    localTextView.setText(azyk.a().a((arpg)localObject));
    int i = 0;
    int j;
    while (i < ((arpg)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((arpi)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((arpi)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((arpi)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new bahf(this, (String)localObject, i, paramView));
      }
      localImageView.setOnTouchListener(mvd.a);
      localImageView.setOnClickListener(new bahg(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        bdll.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!bafb.a((azxr)this.jdField_b_of_type_JavaLangObject)) {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845858));
        } else {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845857));
        }
      }
      localObject = "";
    }
  }
  
  public void a(bbwh parambbwh, View paramView)
  {
    int j = 1;
    parambbwh = parambbwh.a();
    if ((parambbwh instanceof Pair))
    {
      parambbwh = (Pair)parambbwh;
      bbwn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, bbwn.a(((Integer)parambbwh.first).intValue(), (String)parambbwh.second), -1);
      if (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label119;
      }
      i = 1;
      if (i == 0) {
        break label124;
      }
    }
    label119:
    label124:
    for (int i = j;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i, 0, "" + i, "0", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_Boolean = paramBaseActivity.getBooleanExtra("key_from_extends_friend", false);
    }
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    if (this.jdField_a_of_type_Badl != null) {
      this.jdField_a_of_type_Badl.a(this);
    }
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azxr)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_sig";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    if (this.jdField_a_of_type_Badl != null) {
      this.jdField_a_of_type_Badl.b(this);
    }
    if (this.jdField_a_of_type_Bahh != null)
    {
      ((bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).b(this.jdField_a_of_type_Bahh);
      this.jdField_a_of_type_Bahh = null;
    }
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.d();
      this.jdField_a_of_type_Aoof = null;
    }
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
    super.f();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof azvr))
    {
      localObject = (azvr)paramView.getTag();
      switch (((azvr)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bafc.a((azxr)this.jdField_b_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      localObject = (Pair)((azvr)localObject).jdField_a_of_type_JavaLangObject;
      bafc.a(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (CircleBoarderImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!azyk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (ProfileCardMoreInfoView.a(this.jdField_a_of_type_AndroidWidgetTextView))) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new ProfileContentSignComponent.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahb
 * JD-Core Version:    0.7.0.1
 */