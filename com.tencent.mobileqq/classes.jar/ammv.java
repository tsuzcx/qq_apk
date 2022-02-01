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
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ammv
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList<bdwr> a;
  boolean a;
  private boolean b;
  
  public ammv(QQAppInterface paramQQAppInterface, ArrayList<bdwr> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_Boolean = bdgb.b();
  }
  
  private int a(bdwr parambdwr)
  {
    if ((parambdwr.jdField_a_of_type_Int != 3) && (parambdwr.jdField_a_of_type_Int != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((parambdwr.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
        parambdwr = ((SubAccountMessage)parambdwr.jdField_a_of_type_JavaLangObject).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambdwr)) {
          break label178;
        }
        Object localObject = (bdwr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((((bdwr)localObject).jdField_a_of_type_Int != 2) || (((bdwr)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((bdwr)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((bdwr)localObject).jdField_a_of_type_JavaLangObject;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((bdwr)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(parambdwr)))
          {
            return i;
            if (!(parambdwr.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
              break label174;
            }
            parambdwr = ((SubAccountInfo)parambdwr.jdField_a_of_type_JavaLangObject).subuin;
            break;
          }
          i += 1;
        }
        break;
        parambdwr = "";
      }
    }
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject;
    ArrayList localArrayList;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562965, paramViewGroup, false);
      paramViewGroup = new ammw(this);
      paramViewGroup.jdField_a_of_type_Ammx = new ammx(this);
      paramViewGroup.jdField_a_of_type_Ammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378936));
      paramViewGroup.jdField_a_of_type_Ammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_Ammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368212));
      paramViewGroup.jdField_a_of_type_Ammx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368227));
      paramViewGroup.jdField_a_of_type_Ammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380440));
      paramViewGroup.jdField_a_of_type_Ammx.d = paramView.findViewById(2131367671);
      paramViewGroup.jdField_b_of_type_Ammx = new ammx(this);
      paramViewGroup.jdField_b_of_type_Ammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378951));
      paramViewGroup.jdField_b_of_type_Ammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_Ammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368218));
      paramViewGroup.jdField_b_of_type_Ammx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368228));
      paramViewGroup.jdField_b_of_type_Ammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380441));
      paramViewGroup.jdField_b_of_type_Ammx.d = paramView.findViewById(2131367672);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368239);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368240);
      paramViewGroup.c = paramView.findViewById(2131362181);
      ((SingleLineTextView)paramView.findViewById(2131362145)).a().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).a(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      localObject = (bdwr)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Bdwr = ((bdwr)localObject);
      a(paramView, (bdwr)localObject);
      localArrayList = (ArrayList)((bdwr)localObject).jdField_a_of_type_JavaLangObject;
      if (localArrayList.size() != 1) {
        break label469;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.c.setVisibility(0);
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt >= localArrayList.size()) || (paramInt >= 2)) {
        return paramView;
      }
      bdwr localbdwr = (bdwr)localArrayList.get(paramInt);
      ammx localammx = paramViewGroup.jdField_a_of_type_Ammx;
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1)
      {
        localammx = paramViewGroup.jdField_b_of_type_Ammx;
        localObject = paramViewGroup.jdField_b_of_type_AndroidViewView;
      }
      a(localammx, localbdwr, (View)localObject);
      paramInt += 1;
      continue;
      paramViewGroup = (ammw)paramView.getTag();
      break;
      label469:
      paramInt = i;
      if (localArrayList.size() > 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.c.setVisibility(8);
        paramInt = i;
      }
    }
    return paramView;
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131562961;
      if (paramInt2 == 7)
      {
        i = 2131562962;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new ammx(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      bdwr localbdwr = (bdwr)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Bdwr = localbdwr;
      if (localbdwr != null)
      {
        a(paramView, localbdwr);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localbdwr.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localbdwr.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131562964;
      break;
      paramViewGroup = (ammx)paramView.getTag();
    }
  }
  
  private void a(ammx paramammx, bdwr parambdwr, View paramView)
  {
    paramammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(parambdwr.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)parambdwr.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    label115:
    int i;
    if (localObject1 != null)
    {
      localObject2 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (parambdwr.e == 0)
      {
        paramammx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        paramammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
        paramammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
        localObject1 = bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject1).subuin);
        if (((bdwy)localObject1).jdField_a_of_type_Int <= 0) {
          break label251;
        }
        blkk.a(paramammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((bdwy)localObject1).jdField_a_of_type_Int, 0, 99, null);
      }
    }
    else
    {
      paramammx.jdField_a_of_type_Bdwr = parambdwr;
      if (!parambdwr.jdField_b_of_type_Boolean) {
        break label271;
      }
      paramammx.d.setScaleX(1.0F);
      paramammx.d.setScaleY(1.0F);
      boolean bool = bdgb.a();
      localObject1 = paramammx.d;
      localObject2 = paramammx.d.getResources();
      if (!bool) {
        break label263;
      }
      i = 2130846162;
      label173:
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    for (;;)
    {
      paramView.setTag(paramammx);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(parambdwr.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(parambdwr.jdField_d_of_type_JavaLangString);
      }
      return;
      paramammx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850377);
      break;
      label251:
      paramammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      break label115;
      label263:
      i = 2130846161;
      break label173;
      label271:
      paramammx.d.setScaleX(0.93F);
      paramammx.d.setScaleY(0.93F);
      paramammx.d.setBackgroundDrawable(null);
    }
  }
  
  private void a(View paramView, bdwr parambdwr)
  {
    if ((paramView == null) || (parambdwr == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (parambdwr.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365632);
      float f = bhlo.a();
      View localView;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131369001);
        localObject3 = paramView.getLayoutParams();
        if (!parambdwr.jdField_b_of_type_Boolean) {
          break label328;
        }
        localObject2 = paramView.findViewById(2131368982);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839440);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296538));
        localObject1 = (UpArrowView)paramView.findViewById(2131362954);
        localObject2 = (ShadowView)paramView.findViewById(2131362972);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(agej.a(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, agej.a(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, parambdwr);
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
        if (parambdwr.jdField_b_of_type_Int == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label328:
        paramView.setBackgroundResource(2130839440);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296536));
      }
    }
    if (parambdwr.jdField_b_of_type_Boolean)
    {
      localObject1 = paramView.findViewById(2131368982);
      if (localObject1 != null) {
        break label601;
      }
      localObject1 = paramView;
    }
    label599:
    label601:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131362954);
      localObject3 = (ShadowView)paramView.findViewById(2131362972);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(agej.a(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, agej.a(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, parambdwr);
      ((View)localObject1).setBackgroundResource(2130839440);
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label599;
        }
        localObject1 = paramView.findViewById(2131365632);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!parambdwr.jdField_b_of_type_Boolean) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131362954);
        paramView = (ShadowView)paramView.findViewById(2131362972);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(agej.a(6.0F, paramView.getResources()), 0.0F, agej.a(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, parambdwr);
        return;
        paramView.setBackgroundResource(2130839440);
      }
      break;
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    bdwr localbdwr;
    int j;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562966, paramViewGroup, false);
      paramViewGroup = new ammx(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368212));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378936));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380442));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
      localbdwr = (bdwr)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Bdwr = localbdwr;
      SimpleAccount localSimpleAccount = (SimpleAccount)localbdwr.jdField_a_of_type_JavaLangObject;
      aoot localaoot = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbdwr.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localaoot);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
      j = localbdwr.jdField_d_of_type_Int;
      if (j <= 0) {
        break label264;
      }
      i = 2130844825;
    }
    label264:
    for (paramInt = 3;; paramInt = 0)
    {
      blkk.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(localbdwr.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localbdwr.jdField_d_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (ammx)paramView.getTag();
      break;
    }
  }
  
  private void b(View paramView, bdwr parambdwr)
  {
    if ((paramView == null) || (parambdwr == null)) {
      return;
    }
    int i = a(parambdwr);
    parambdwr = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = agej.a(43.0F, paramView.getResources());
    parambdwr.leftMargin = (i * agej.a(73.0F, paramView.getResources()) + j - agej.a(6.0F, paramView.getResources()));
    paramView.setLayoutParams(parambdwr);
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ammx localammx;
    bdwr localbdwr;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562960, paramViewGroup, false);
      localammx = new ammx(this);
      localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131378936));
      localammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131368212));
      localammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131380442));
      localammx.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365413));
      paramViewGroup.setTag(localammx);
      localbdwr = (bdwr)getItem(paramInt);
      localammx.jdField_a_of_type_Bdwr = localbdwr;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localbdwr != null)
      {
        localSubAccountMessage = (SubAccountMessage)localbdwr.jdField_a_of_type_JavaLangObject;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131718440);
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
      localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new begp(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131718441);
          localammx.b.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = bhsw.a(localSubAccountMessage.time * 1000L, true, bdwt.jdField_a_of_type_JavaLangString);
          }
          if (localSubAccountMessage.istroop != 1) {
            localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!antf.aD.equals(localSubAccountMessage.senderuin)) {
            break label907;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130842432);
        if (!this.jdField_b_of_type_Boolean) {
          break label874;
        }
        paramView = QQAppInterface.a(paramView, 3, 50, 50);
        label380:
        localammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
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
      localammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int n = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((n > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130850400;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label441:
        localammx.b.setExtendText(paramView, 1);
        localammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        blkk.a(localammx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.c) && (TextUtils.isEmpty(localbdwr.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localbdwr.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localbdwr.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = bhlo.a();
          paramView = localResources.getColorStateList(2131167070);
          localObject = localResources.getColorStateList(2131166990);
          i = localResources.getColor(2131167102);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localammx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1151;
          }
          localammx.b.setTextColor(i);
        }
        for (;;)
        {
          localammx.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localammx.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localammx.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localbdwr);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.c) && (!TextUtils.isEmpty(localbdwr.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localbdwr.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365647);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localammx = (ammx)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131718442);
          break label258;
          localammx.b.setText(localSubAccountMessage.mEmoRecentMsg);
          break label267;
          label874:
          paramView = QQAppInterface.a(paramView, 50, 50);
          break label380;
          paramView = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
          localammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
          localammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
          localammx.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
          break label389;
          if (n <= 0) {
            break label1163;
          }
          paramInt = 2130850404;
          int k = 3;
          if ((2 == localbdwr.c) || (3 == localbdwr.c))
          {
            paramView = "[" + localResources.getString(2131716142) + "]";
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
          if (localbdwr.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label526;
          }
          if (localbdwr.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label526;
          }
          if (localbdwr.jdField_d_of_type_Int <= 0) {
            break label526;
          }
          localStringBuilder.append("有").append(localbdwr.jdField_d_of_type_Int).append("条未读,");
          break label526;
          label1151:
          localammx.b.setTextColor(paramView);
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
      return ((bdwr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
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
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562963, paramViewGroup, false);
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
 * Qualified Name:     ammv
 * JD-Core Version:    0.7.0.1
 */