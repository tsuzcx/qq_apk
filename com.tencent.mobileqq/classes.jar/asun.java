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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1;
import com.tencent.mobileqq.extendfriend.wiget.LabelLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class asun
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private asmp jdField_a_of_type_Asmp;
  private asuo jdField_a_of_type_Asuo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDrawable jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  
  public asun(BaseActivity paramBaseActivity, int paramInt, asuo paramasuo, asmp paramasmp)
  {
    super(paramBaseActivity, 2131755829);
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Asmp = paramasmp;
    this.jdField_a_of_type_Asuo = paramasuo;
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
  
  private asvf a(int paramInt, String paramString)
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
      str = localContext.getString(2131693752);
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
    for (paramString = localContext.getResources().getDrawable(2130845086);; paramString = localContext.getResources().getDrawable(2130845085))
    {
      paramInt = ViewUtils.dip2px(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new asvf();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      return paramString;
      str = localContext.getString(2131692198);
      break;
      paramString = str + " " + paramString;
      break label48;
      i = Color.parseColor("#33FF80BF");
      break label69;
      j = Color.parseColor("#FF80BF");
      break label81;
    }
  }
  
  private asvf a(long paramLong)
  {
    int i = ViewUtils.dip2px(11.0F);
    Object localObject1 = getContext().getResources().getDrawable(2130845087);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
    String str = getContext().getString(2131693752);
    localObject1 = new SpannableString(str + " " + paramLong);
    ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
    localObject2 = new asvf();
    ((asvf)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
    ((asvf)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
    ((asvf)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
    return localObject2;
  }
  
  private void a()
  {
    setContentView(2131561143);
    if (this.jdField_a_of_type_Int == 1)
    {
      findViewById(2131367929).setVisibility(0);
      findViewById(2131377765).setVisibility(8);
      findViewById(2131377341).setOnClickListener(this);
    }
    Object localObject1;
    label647:
    do
    {
      for (;;)
      {
        findViewById(2131364700).setOnClickListener(this);
        localObject1 = findViewById(2131378856);
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
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367929);
          ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367929);
        }
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          findViewById(2131367929).setVisibility(8);
          findViewById(2131377765).setVisibility(0);
          findViewById(2131377045).setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131363145);
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Asmp.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          Object localObject2 = (TextView)findViewById(2131371958);
          if (this.jdField_a_of_type_Asmp.jdField_b_of_type_JavaLangString == null) {}
          Object localObject3;
          for (localObject1 = "";; localObject1 = this.jdField_a_of_type_Asmp.jdField_b_of_type_JavaLangString)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject1 = (TextView)findViewById(2131377080);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Asmp.d)) {
              break;
            }
            ((TextView)localObject1).setVisibility(8);
            ((TextView)findViewById(2131365749)).setText(String.format(getContext().getString(2131698529), new Object[] { asru.a(this.jdField_a_of_type_Asmp.jdField_a_of_type_Int) }));
            localObject1 = getContext().getResources().getStringArray(2130968660);
            localObject2 = getContext().getResources().getStringArray(2130968659);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Asmp.jdField_b_of_type_Int, this.jdField_a_of_type_Asmp.e));
            if (this.jdField_a_of_type_Asmp.jdField_b_of_type_Long > 0L) {
              ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Asmp.jdField_b_of_type_Long));
            }
            if (this.jdField_a_of_type_Asmp.jdField_a_of_type_JavaUtilArrayList == null) {
              break label647;
            }
            Iterator localIterator = this.jdField_a_of_type_Asmp.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!TextUtils.isEmpty(str))
              {
                asvf localasvf = new asvf();
                localasvf.jdField_a_of_type_JavaLangCharSequence = str;
                i = localasvf.jdField_a_of_type_JavaLangCharSequence.charAt(0);
                localasvf.jdField_b_of_type_Int = Color.parseColor(localObject1[(i % localObject1.length)]);
                localasvf.jdField_a_of_type_Int = Color.parseColor(localObject2[(i % localObject2.length)]);
                ((ArrayList)localObject3).add(localasvf);
              }
            }
          }
          ((TextView)localObject1).setVisibility(0);
          if (this.jdField_a_of_type_Asmp.a()) {}
          for (int i = 2130845139;; i = 2130845140)
          {
            localObject2 = getContext().getResources().getDrawable(i);
            i = ViewUtils.dip2px(15.0F);
            ((Drawable)localObject2).setBounds(0, 0, i, i);
            localObject2 = new ImageSpan((Drawable)localObject2, 0);
            localObject3 = new SpannableString(" " + this.jdField_a_of_type_Asmp.d);
            ((SpannableString)localObject3).setSpan(localObject2, 0, " ".length(), 17);
            ((TextView)localObject1).setText((CharSequence)localObject3);
            break;
          }
          a((List)localObject3);
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131377765);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131377765);
    return;
    label681:
    ((View)localObject1).setVisibility(8);
  }
  
  public static void a(BaseActivity paramBaseActivity, asmp paramasmp, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()) && (paramasmp != null))
    {
      paramBaseActivity = new asun(paramBaseActivity, 2, null, paramasmp);
      paramBaseActivity.setOnDismissListener(paramOnDismissListener);
      paramBaseActivity.show();
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, asuo paramasuo)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      new asun(paramBaseActivity, 1, paramasuo, null).show();
    }
  }
  
  private void a(List<asvf> paramList)
  {
    LabelLayout localLabelLayout1 = (LabelLayout)findViewById(2131369758);
    LabelLayout localLabelLayout2 = (LabelLayout)findViewById(2131369759);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298192);
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE97", "0X800AE97", 0, 0, "", "", "", "");
    c();
    dismiss();
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSignalBombDialog.1(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable.cancel();
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE98", "0X800AE98", 0, 0, "", "", "", "");
      QLog.d("ExtendFriendSignalBombDialog", 2, " closeBtn signal bomb dialog ");
      c();
      dismiss();
      continue;
      QLog.d("ExtendFriendSignalBombDialog", 2, " sendBtn signal bomb dialog ");
      c();
      dismiss();
      if (this.jdField_a_of_type_Asuo != null)
      {
        this.jdField_a_of_type_Asuo.a();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " sayHelloBtn signal bomb dialog ");
        b();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " avatar signal bomb dialog ");
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_Asmp.jdField_a_of_type_JavaLangString, 96);
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
 * Qualified Name:     asun
 * JD-Core Version:    0.7.0.1
 */