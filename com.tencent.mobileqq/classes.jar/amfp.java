import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class amfp
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList<bdxh> a;
  boolean a;
  private boolean b;
  
  public amfp(QQAppInterface paramQQAppInterface, ArrayList<bdxh> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_Boolean = bdfk.b();
  }
  
  private int a(bdxh parambdxh)
  {
    if ((parambdxh.jdField_a_of_type_Int != 3) && (parambdxh.jdField_a_of_type_Int != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((parambdxh.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
        parambdxh = ((SubAccountMessage)parambdxh.jdField_a_of_type_JavaLangObject).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambdxh)) {
          break label178;
        }
        Object localObject = (bdxh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((((bdxh)localObject).jdField_a_of_type_Int != 2) || (((bdxh)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((bdxh)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((bdxh)localObject).jdField_a_of_type_JavaLangObject;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((bdxh)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(parambdxh)))
          {
            return i;
            if (!(parambdxh.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
              break label174;
            }
            parambdxh = ((SubAccountInfo)parambdxh.jdField_a_of_type_JavaLangObject).subuin;
            break;
          }
          i += 1;
        }
        break;
        parambdxh = "";
      }
    }
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562915, paramViewGroup, false);
      paramViewGroup = new amfq(this);
      paramViewGroup.jdField_a_of_type_Amfr = new amfr(this);
      paramViewGroup.jdField_a_of_type_Amfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379001));
      paramViewGroup.jdField_a_of_type_Amfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_Amfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368381));
      paramViewGroup.jdField_a_of_type_Amfr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368396));
      paramViewGroup.jdField_a_of_type_Amfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380499));
      paramViewGroup.jdField_a_of_type_Amfr.d = paramView.findViewById(2131367839);
      paramViewGroup.jdField_b_of_type_Amfr = new amfr(this);
      paramViewGroup.jdField_b_of_type_Amfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379016));
      paramViewGroup.jdField_b_of_type_Amfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_Amfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368387));
      paramViewGroup.jdField_b_of_type_Amfr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368397));
      paramViewGroup.jdField_b_of_type_Amfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380500));
      paramViewGroup.jdField_b_of_type_Amfr.d = paramView.findViewById(2131367840);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368408);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368409);
      paramViewGroup.c = paramView.findViewById(2131362184);
      ((SingleLineTextView)paramView.findViewById(2131362149)).getPaint().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).a(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      localObject = (bdxh)getItem(paramInt);
      if (localObject != null) {
        break label345;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (amfq)paramView.getTag();
      break;
      label345:
      paramViewGroup.jdField_a_of_type_Bdxh = ((bdxh)localObject);
      a(paramView, (bdxh)localObject);
      ArrayList localArrayList = (ArrayList)((bdxh)localObject).jdField_a_of_type_JavaLangObject;
      if (localArrayList.size() == 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.c.setVisibility(0);
        paramInt = i;
      }
      while ((paramInt < localArrayList.size()) && (paramInt < 2))
      {
        bdxh localbdxh = (bdxh)localArrayList.get(paramInt);
        amfr localamfr = paramViewGroup.jdField_a_of_type_Amfr;
        localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
        if (paramInt == 1)
        {
          localamfr = paramViewGroup.jdField_b_of_type_Amfr;
          localObject = paramViewGroup.jdField_b_of_type_AndroidViewView;
        }
        a(localamfr, localbdxh, (View)localObject);
        paramInt += 1;
        continue;
        paramInt = i;
        if (localArrayList.size() > 1)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.c.setVisibility(8);
          paramInt = i;
        }
      }
    }
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131562911;
      if (paramInt2 == 7)
      {
        i = 2131562912;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new amfr(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      bdxh localbdxh = (bdxh)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Bdxh = localbdxh;
      if (localbdxh != null)
      {
        a(paramView, localbdxh);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localbdxh.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localbdxh.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131562914;
      break;
      paramViewGroup = (amfr)paramView.getTag();
    }
  }
  
  private void a(amfr paramamfr, bdxh parambdxh, View paramView)
  {
    paramamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(parambdxh.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)parambdxh.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    label115:
    int i;
    if (localObject1 != null)
    {
      localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (parambdxh.e == 0)
      {
        paramamfr.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        paramamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
        paramamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
        localObject1 = bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject1).subuin);
        if (((bdxo)localObject1).jdField_a_of_type_Int <= 0) {
          break label251;
        }
        blas.a(paramamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((bdxo)localObject1).jdField_a_of_type_Int, 0, 99, null);
      }
    }
    else
    {
      paramamfr.jdField_a_of_type_Bdxh = parambdxh;
      if (!parambdxh.jdField_b_of_type_Boolean) {
        break label271;
      }
      paramamfr.d.setScaleX(1.0F);
      paramamfr.d.setScaleY(1.0F);
      boolean bool = bdfk.a();
      localObject1 = paramamfr.d;
      localObject2 = paramamfr.d.getResources();
      if (!bool) {
        break label263;
      }
      i = 2130846141;
      label173:
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    for (;;)
    {
      paramView.setTag(paramamfr);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(parambdxh.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(parambdxh.jdField_d_of_type_JavaLangString);
      }
      return;
      paramamfr.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850402);
      break;
      label251:
      paramamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      break label115;
      label263:
      i = 2130846140;
      break label173;
      label271:
      paramamfr.d.setScaleX(0.93F);
      paramamfr.d.setScaleY(0.93F);
      paramamfr.d.setBackgroundDrawable(null);
    }
  }
  
  private void a(View paramView, bdxh parambdxh)
  {
    if ((paramView == null) || (parambdxh == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (parambdxh.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365759);
      float f = DeviceInfoUtil.getDesity();
      View localView;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131369190);
        localObject3 = paramView.getLayoutParams();
        if (!parambdxh.jdField_b_of_type_Boolean) {
          break label328;
        }
        localObject2 = paramView.findViewById(2131369169);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839496);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296591));
        localObject1 = (UpArrowView)paramView.findViewById(2131362985);
        localObject2 = (ShadowView)paramView.findViewById(2131363003);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(AIOUtils.dp2px(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, AIOUtils.dp2px(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, parambdxh);
        }
      }
      for (;;)
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        return;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(8);
        if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break;
        }
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        if (parambdxh.jdField_b_of_type_Int == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label328:
        paramView.setBackgroundResource(2130839496);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296589));
      }
    }
    if (parambdxh.jdField_b_of_type_Boolean)
    {
      localObject1 = paramView.findViewById(2131369169);
      if (localObject1 != null) {
        break label601;
      }
      localObject1 = paramView;
    }
    label599:
    label601:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131362985);
      localObject3 = (ShadowView)paramView.findViewById(2131363003);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(AIOUtils.dp2px(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, AIOUtils.dp2px(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, parambdxh);
      ((View)localObject1).setBackgroundResource(2130839496);
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label599;
        }
        localObject1 = paramView.findViewById(2131365759);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!parambdxh.jdField_b_of_type_Boolean) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131362985);
        paramView = (ShadowView)paramView.findViewById(2131363003);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(AIOUtils.dp2px(6.0F, paramView.getResources()), 0.0F, AIOUtils.dp2px(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, parambdxh);
        return;
        paramView.setBackgroundResource(2130839496);
      }
      break;
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562916, paramViewGroup, false);
      paramViewGroup = new amfr(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368381));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379001));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380501));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
    }
    bdxh localbdxh;
    for (;;)
    {
      localbdxh = (bdxh)getItem(paramInt);
      if (localbdxh != null) {
        break;
      }
      return paramView;
      paramViewGroup = (amfr)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_Bdxh = localbdxh;
    SimpleAccount localSimpleAccount = (SimpleAccount)localbdxh.jdField_a_of_type_JavaLangObject;
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbdxh.jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localFaceDrawable);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
    int j = localbdxh.jdField_d_of_type_Int;
    if (j > 0) {
      i = 2130844770;
    }
    for (paramInt = 3;; paramInt = 0)
    {
      blas.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((!AppSetting.c) || (TextUtils.isEmpty(localbdxh.jdField_d_of_type_JavaLangString))) {
        break;
      }
      paramView.setContentDescription(localbdxh.jdField_d_of_type_JavaLangString);
      return paramView;
    }
  }
  
  private void b(View paramView, bdxh parambdxh)
  {
    if ((paramView == null) || (parambdxh == null)) {
      return;
    }
    int i = a(parambdxh);
    parambdxh = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = AIOUtils.dp2px(43.0F, paramView.getResources());
    parambdxh.leftMargin = (i * AIOUtils.dp2px(73.0F, paramView.getResources()) + j - AIOUtils.dp2px(6.0F, paramView.getResources()));
    paramView.setLayoutParams(parambdxh);
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    amfr localamfr;
    bdxh localbdxh;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562910, paramViewGroup, false);
      localamfr = new amfr(this);
      localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131379001));
      localamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131368381));
      localamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131380501));
      localamfr.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365538));
      paramViewGroup.setTag(localamfr);
      localbdxh = (bdxh)getItem(paramInt);
      localamfr.jdField_a_of_type_Bdxh = localbdxh;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localbdxh != null)
      {
        localSubAccountMessage = (SubAccountMessage)localbdxh.jdField_a_of_type_JavaLangObject;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131719077);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1171;
        }
      }
    }
    label258:
    label267:
    label526:
    label1171:
    for (Object localObject = localSubAccountMessage.senderuin;; localObject = paramView)
    {
      localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131719078);
          localamfr.b.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = bhid.a(localSubAccountMessage.time * 1000L, true, bdxj.jdField_a_of_type_JavaLangString);
          }
          if (localSubAccountMessage.istroop != 1) {
            localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!AppConstants.SUBACCOUNT_TROOP_UIN.equals(localSubAccountMessage.senderuin)) {
            break label907;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130842508);
        if (!this.jdField_b_of_type_Boolean) {
          break label874;
        }
        paramView = QQAppInterface.getShapeRoundFaceBitmap(paramView, 3, 50, 50);
        label380:
        localamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(paramView));
          }
        }
      }
      localamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int n = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((n > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130850427;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label441:
        localamfr.b.setExtendText(paramView, 1);
        localamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        blas.a(localamfr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.c) && (TextUtils.isEmpty(localbdxh.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localbdxh.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localbdxh.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = DeviceInfoUtil.getDesity();
          paramView = localResources.getColorStateList(2131167106);
          localObject = localResources.getColorStateList(2131167026);
          i = localResources.getColor(2131167138);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localamfr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1151;
          }
          localamfr.b.setTextColor(i);
        }
        for (;;)
        {
          localamfr.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localamfr.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localamfr.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localbdxh);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.c) && (!TextUtils.isEmpty(localbdxh.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localbdxh.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365774);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localamfr = (amfr)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131719079);
          break label258;
          localamfr.b.setText(localSubAccountMessage.mEmoRecentMsg);
          break label267;
          label874:
          paramView = QQAppInterface.getCircleFaceBitmap(paramView, 50, 50);
          break label380;
          paramView = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
          localamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
          localamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
          localamfr.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
          break label389;
          if (n <= 0) {
            break label1163;
          }
          paramInt = 2130850431;
          int k = 3;
          if ((2 == localbdxh.c) || (3 == localbdxh.c))
          {
            paramView = "[" + localResources.getString(2131716737) + "]";
            m = 0;
            i = k;
            j = paramInt;
            paramInt = m;
            break label441;
          }
          i = k;
          j = paramInt;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label1163;
          }
          paramView = "";
          int m = 1;
          i = k;
          j = paramInt;
          paramInt = m;
          break label441;
          if (localbdxh.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label526;
          }
          if (localbdxh.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label526;
          }
          if (localbdxh.jdField_d_of_type_Int <= 0) {
            break label526;
          }
          localStringBuilder.append("有").append(localbdxh.jdField_d_of_type_Int).append("条未读,");
          break label526;
          label1151:
          localamfr.b.setTextColor(paramView);
        }
        paramView = "";
        paramInt = 0;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((bdxh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    View localView;
    switch (i)
    {
    case 5: 
    default: 
      localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562913, paramViewGroup, false);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = c(paramInt, paramView, paramViewGroup);
      continue;
      localView = b(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup, i);
    }
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfp
 * JD-Core Version:    0.7.0.1
 */