import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1;
import com.tencent.mobileqq.extendfriend.wiget.LabelLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class asnv
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private aoch jdField_a_of_type_Aoch;
  private asgs jdField_a_of_type_Asgs;
  private asnw jdField_a_of_type_Asnw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asnv(BaseActivity paramBaseActivity, int paramInt, asnw paramasnw, asgs paramasgs)
  {
    super(paramBaseActivity, 2131755823);
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Asgs = paramasgs;
    this.jdField_a_of_type_Asnw = paramasnw;
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      }
    }
    a();
    QLog.d("ExtendFriendSignalBombDialog", 2, " init dialog signal bomb");
  }
  
  private ason a(int paramInt, String paramString)
  {
    Context localContext = getContext();
    String str;
    label48:
    SpannableString localSpannableString;
    int i;
    label69:
    int j;
    if (paramInt == 1)
    {
      str = localContext.getString(2131693461);
      if (!TextUtils.isEmpty(paramString)) {
        break label172;
      }
      paramString = str + " ";
      localSpannableString = new SpannableString(paramString);
      if (paramInt != 1) {
        break label200;
      }
      i = Color.parseColor("#3300CAFC");
      if (paramInt != 1) {
        break label209;
      }
      j = Color.parseColor("#02B2DD");
      label81:
      if (paramInt != 1) {
        break label219;
      }
    }
    label172:
    label200:
    label209:
    label219:
    for (paramString = localContext.getResources().getDrawable(2130845110);; paramString = localContext.getResources().getDrawable(2130845109))
    {
      paramInt = bgtn.a(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new ason();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      return paramString;
      str = localContext.getString(2131692055);
      break;
      paramString = str + " " + paramString;
      break label48;
      i = Color.parseColor("#33FF80BF");
      break label69;
      j = Color.parseColor("#FF80BF");
      break label81;
    }
  }
  
  private ason a(long paramLong)
  {
    int i = bgtn.a(11.0F);
    Object localObject1 = getContext().getResources().getDrawable(2130845111);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
    String str = getContext().getString(2131693461);
    localObject1 = new SpannableString(str + " " + paramLong);
    ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
    localObject2 = new ason();
    ((ason)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
    ((ason)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
    ((ason)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
    return localObject2;
  }
  
  private void a()
  {
    setContentView(2131561171);
    if (this.jdField_a_of_type_Int == 1)
    {
      findViewById(2131367691).setVisibility(0);
      findViewById(2131377570).setVisibility(8);
      findViewById(2131377176).setOnClickListener(this);
    }
    Object localObject1;
    label647:
    do
    {
      for (;;)
      {
        findViewById(2131364540).setOnClickListener(this);
        localObject1 = findViewById(2131378642);
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label681;
        }
        ((View)localObject1).setVisibility(0);
        if ((((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (this.jdField_a_of_type_Int != 1) {
            break;
          }
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367691);
          ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367691);
        }
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          findViewById(2131367691).setVisibility(8);
          findViewById(2131377570).setVisibility(0);
          findViewById(2131376887).setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131363088);
          this.jdField_a_of_type_Aoch = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Asgs.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Aoch);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          Object localObject2 = (TextView)findViewById(2131371697);
          if (this.jdField_a_of_type_Asgs.jdField_b_of_type_JavaLangString == null) {}
          Object localObject3;
          for (localObject1 = "";; localObject1 = this.jdField_a_of_type_Asgs.jdField_b_of_type_JavaLangString)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject1 = (TextView)findViewById(2131376920);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Asgs.d)) {
              break;
            }
            ((TextView)localObject1).setVisibility(8);
            ((TextView)findViewById(2131365581)).setText(String.format(getContext().getString(2131697979), new Object[] { aslj.a(this.jdField_a_of_type_Asgs.jdField_a_of_type_Int) }));
            localObject1 = getContext().getResources().getStringArray(2130968660);
            localObject2 = getContext().getResources().getStringArray(2130968659);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Asgs.jdField_b_of_type_Int, this.jdField_a_of_type_Asgs.e));
            if (this.jdField_a_of_type_Asgs.jdField_b_of_type_Long > 0L) {
              ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Asgs.jdField_b_of_type_Long));
            }
            if (this.jdField_a_of_type_Asgs.jdField_a_of_type_JavaUtilArrayList == null) {
              break label647;
            }
            Iterator localIterator = this.jdField_a_of_type_Asgs.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!TextUtils.isEmpty(str))
              {
                ason localason = new ason();
                localason.jdField_a_of_type_JavaLangCharSequence = str;
                i = localason.jdField_a_of_type_JavaLangCharSequence.charAt(0);
                localason.jdField_b_of_type_Int = Color.parseColor(localObject1[(i % localObject1.length)]);
                localason.jdField_a_of_type_Int = Color.parseColor(localObject2[(i % localObject2.length)]);
                ((ArrayList)localObject3).add(localason);
              }
            }
          }
          ((TextView)localObject1).setVisibility(0);
          if (this.jdField_a_of_type_Asgs.a()) {}
          for (int i = 2130845163;; i = 2130845164)
          {
            localObject2 = getContext().getResources().getDrawable(i);
            i = bgtn.a(15.0F);
            ((Drawable)localObject2).setBounds(0, 0, i, i);
            localObject2 = new ImageSpan((Drawable)localObject2, 0);
            localObject3 = new SpannableString(" " + this.jdField_a_of_type_Asgs.d);
            ((SpannableString)localObject3).setSpan(localObject2, 0, " ".length(), 17);
            ((TextView)localObject1).setText((CharSequence)localObject3);
            break;
          }
          a((List)localObject3);
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131377570);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131377570);
    return;
    label681:
    ((View)localObject1).setVisibility(8);
  }
  
  public static void a(BaseActivity paramBaseActivity, asgs paramasgs, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()) && (paramasgs != null))
    {
      paramBaseActivity = new asnv(paramBaseActivity, 2, null, paramasgs);
      paramBaseActivity.setOnDismissListener(paramOnDismissListener);
      paramBaseActivity.show();
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, asnw paramasnw)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      new asnv(paramBaseActivity, 1, paramasnw, null).show();
    }
  }
  
  private void a(List<ason> paramList)
  {
    LabelLayout localLabelLayout1 = (LabelLayout)findViewById(2131369505);
    LabelLayout localLabelLayout2 = (LabelLayout)findViewById(2131369506);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298112);
      int j = localLabelLayout1.a(i, paramList, true, 12);
      if (j > 0)
      {
        localLabelLayout1.setVisibility(0);
        if (j < paramList.size())
        {
          if (localLabelLayout2.a(i, paramList.subList(j, paramList.size()), true, 12) > 0) {}
          for (i = 0;; i = 8)
          {
            localLabelLayout2.setVisibility(i);
            return;
          }
        }
        localLabelLayout2.setVisibility(8);
        return;
      }
      localLabelLayout1.setVisibility(8);
      return;
    }
    localLabelLayout1.setVisibility(8);
    localLabelLayout2.setVisibility(8);
  }
  
  private void b()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE97", "0X800AE97", 0, 0, "", "", "", "");
    c();
    dismiss();
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSignalBombDialog.1(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aoch != null) {
      this.jdField_a_of_type_Aoch.b();
    }
  }
  
  public void onBackPressed()
  {
    c();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE98", "0X800AE98", 0, 0, "", "", "", "");
      QLog.d("ExtendFriendSignalBombDialog", 2, " closeBtn signal bomb dialog ");
      c();
      dismiss();
      continue;
      QLog.d("ExtendFriendSignalBombDialog", 2, " sendBtn signal bomb dialog ");
      c();
      dismiss();
      if (this.jdField_a_of_type_Asnw != null)
      {
        this.jdField_a_of_type_Asnw.a();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " sayHelloBtn signal bomb dialog ");
        b();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " avatar signal bomb dialog ");
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_Asgs.jdField_a_of_type_JavaLangString, 96);
        localAllInOne.l = 11;
        Intent localIntent = new Intent(getContext(), FriendProfileCardActivity.class);
        localIntent.putExtra("AllInOne", localAllInOne);
        localIntent.putExtra("key_from_extends_friend_limit_chat", true);
        localIntent.addFlags(536870912);
        getContext().startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnv
 * JD-Core Version:    0.7.0.1
 */