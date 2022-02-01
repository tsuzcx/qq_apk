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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.2;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleBoarderImageView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;

public class babn
  extends azwo
  implements View.OnClickListener, bbws, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new babo(this);
  private babt jdField_a_of_type_Babt;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public babn(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
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
    paramView.setContentDescription(anvx.a(2131707938) + localStringBuilder);
  }
  
  private void a(RichStatus paramRichStatus, bbvn parambbvn)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if ((this.jdField_a_of_type_Babt == null) && (parambbvn != null))
      {
        this.jdField_a_of_type_Babt = new babt(this);
        parambbvn.a(this.jdField_a_of_type_Babt);
      }
    }
    do
    {
      return;
      ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    } while ((this.jdField_a_of_type_Babt == null) || (parambbvn == null));
    parambbvn.b(this.jdField_a_of_type_Babt);
    this.jdField_a_of_type_Babt = null;
  }
  
  private void a(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, true);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bheg.a();
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
      bdla.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i, 0, "" + i, "0", "", "");
      label152:
      label204:
      label235:
      boolean bool1;
      if ((!azru.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.jdField_a_of_type_Boolean))
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
        azru.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRichStatus);
        bool1 = azru.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramRichStatus = (ImageView)paramView.findViewById(2131379115);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
          break label554;
        }
      }
      try
      {
        paramSpannableString.mergeFrom(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramSpannableString = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramSpannableString != null) {}
        for (paramSpannableString = paramSpannableString.rpt_topic_item.get();; paramSpannableString = null)
        {
          long l = azru.a().a(paramSpannableString);
          boolean bool2 = azru.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
          if ((!bool1) && (!bool2)) {
            break label546;
          }
          i = azru.a().a(paramSpannableString);
          if ((paramSpannableString == null) || (paramSpannableString.size() <= 0) || (i <= 0)) {
            break label526;
          }
          paramLinearLayout.setTag(new azpb(97, azru.a().a(paramSpannableString)));
          paramLinearLayout.setOnClickListener(this);
          a(paramLinearLayout, paramSpannableString);
          paramRichStatus.setOnTouchListener(mvk.a);
          paramRichStatus.setOnClickListener(new babp(this, paramLinearLayout));
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
  
  private void a(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, TextView paramTextView, LinearLayout paramLinearLayout, bbvn parambbvn)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      paramLinearLayout = new SpannableStringBuilder(paramSpannableString);
      paramLinearLayout.insert(0, "[S] ");
      if (parambbvn != null) {}
      for (paramSpannableString = parambbvn.a(paramRichStatus.actionId, 200);; paramSpannableString = bgyo.a(localResources, 2130849591))
      {
        int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramSpannableString = new bity(localResources, paramSpannableString, false, false);
        paramSpannableString.setBounds(0, 0, i, i);
        paramSpannableString = new biqh(paramSpannableString, 0);
        paramSpannableString.a(-0.1F);
        paramLinearLayout.setSpan(paramSpannableString, 0, "[S]".length(), 17);
        this.jdField_b_of_type_Int = i;
        paramTextView.setText(new QQText(paramLinearLayout, 1, 20));
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
    }
    this.jdField_b_of_type_Int = 0;
    if ((paramSpannableString.length() == 0) && (paramBoolean))
    {
      paramTextView.setText(2131698804);
      a(paramLinearLayout, paramBoolean);
      return;
    }
    paramTextView.setText(new QQText(paramSpannableString, 1, 20));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong)
  {
    int i;
    EntityManager localEntityManager;
    Object localObject;
    if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i != 0)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject != null) {
          break label150;
        }
        localObject = null;
        label59:
        if (localObject != null) {
          break label173;
        }
        localObject = new Card();
        ((Card)localObject).uin = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        ((Card)localObject).vRichSign = paramArrayOfByte;
        ((Card)localObject).lSignModifyTime = paramLong;
        localEntityManager.persist((Entity)localObject);
      }
    }
    for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = (byte[])localObject)
    {
      ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfByte.getRichStatus();
      a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      return;
      i = 0;
      break;
      label150:
      localObject = ((anvk)localObject).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break label59;
      label173:
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
    if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      paramBoolean = true;
      bool = ProfileActivity.AllInOne.g(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (!azym.a((azrb)this.jdField_b_of_type_JavaLangObject)) {
        break label235;
      }
      i = ((Resources)localObject1).getColor(2131167026);
      j = ((Resources)localObject1).getColor(2131167026);
      localObject2 = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramCard != null) {
          localObject1 = paramCard.getRichStatus();
        }
      }
      if (localObject1 == null) {
        break label512;
      }
    }
    label512:
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
          break label510;
        }
        this.jdField_a_of_type_JavaLangObject = null;
        return true;
        paramBoolean = false;
        break;
        label235:
        j = ((Resources)localObject1).getColor(2131165357);
        i = -8947849;
        break label74;
      }
      Object localObject3;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        localObject3 = this.jdField_a_of_type_Baea.a(a_());
        paramCard = (Card)localObject3;
        if (localObject3 == null) {
          paramCard = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561421, null);
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
      }
      for (bool = true;; bool = false)
      {
        View localView = (View)this.jdField_a_of_type_JavaLangObject;
        paramCard = localView.findViewById(2131374418);
        localObject3 = (TextView)localView.findViewById(2131368819);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131370399);
        ((TextView)localObject3).setTextColor(i);
        bbvn localbbvn = (bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        a(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, (TextView)localObject3, localLinearLayout, localbbvn);
        a(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, localView, (TextView)localObject3, localLinearLayout);
        a((RichStatus)localObject1, paramCard);
        a((RichStatus)localObject1, localbbvn);
        localObject1 = (ImageView)localView.findViewById(2131362985);
        if ((paramBoolean) || (ProfileActivity.AllInOne.b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          ((ImageView)localObject1).setVisibility(0);
          paramCard.setTag(new azpb(3, null));
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
      label510:
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
      Object localObject = (RelativeLayout)paramView.findViewById(2131366872);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      localObject = (CircleBoarderImageView)paramView.findViewById(2131364645);
      CircleBoarderImageView localCircleBoarderImageView = (CircleBoarderImageView)paramView.findViewById(2131364646);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131364647);
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
    ((RelativeLayout)paramView.findViewById(2131366872)).setVisibility(0);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131364645);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364646);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364647);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131379852);
    Collections.sort(paramList, new babq(this));
    int j = azru.a().a(paramList);
    paramList = azru.a().a(paramList);
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
      paramList = j + anvx.a(2131707935);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label461;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = anvx.a(2131707905) + j + anvx.a(2131707884);
      break;
      label461:
      if (!azym.a((azrb)this.jdField_b_of_type_JavaLangObject)) {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845846));
      } else {
        paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845845));
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
    if (!azru.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = arms.a();
    if ((localObject == null) || (((armp)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    a(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((armp)localObject).a().a;
    TextView localTextView = (TextView)paramView.findViewById(2131379852);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379115);
    localTextView.setText(azru.a().a((armp)localObject));
    int i = 0;
    int j;
    while (i < ((armp)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((armr)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((armr)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((armr)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new babr(this, (String)localObject, i, paramView));
      }
      localImageView.setOnTouchListener(mvk.a);
      localImageView.setOnClickListener(new babs(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!azym.a((azrb)this.jdField_b_of_type_JavaLangObject)) {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845846));
        } else {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845845));
        }
      }
      localObject = "";
    }
  }
  
  public void a(bbwr parambbwr, View paramView)
  {
    int j = 1;
    parambbwr = parambbwr.a();
    if ((parambbwr instanceof Pair))
    {
      parambbwr = (Pair)parambbwr;
      bbwx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, bbwx.a(((Integer)parambbwr.first).intValue(), (String)parambbwr.second), -1);
      if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
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
      bdla.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i, 0, "" + i, "0", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.a(this);
    }
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azrb)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_sig";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.b(this);
    }
    if (this.jdField_a_of_type_Babt != null)
    {
      ((bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).b(this.jdField_a_of_type_Babt);
      this.jdField_a_of_type_Babt = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
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
    if ((paramView.getTag() instanceof azpb))
    {
      localObject = (azpb)paramView.getTag();
      switch (((azpb)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      azyn.a((azrb)this.jdField_b_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      localObject = (Pair)((azpb)localObject).jdField_a_of_type_JavaLangObject;
      azyn.a(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((paramInt == 0) && (!azru.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (ProfileCardMoreInfoView.a(this.jdField_a_of_type_AndroidWidgetTextView))) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new ProfileContentSignComponent.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babn
 * JD-Core Version:    0.7.0.1
 */