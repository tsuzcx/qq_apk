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

public class atdz
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private aoot jdField_a_of_type_Aoot;
  private aswg jdField_a_of_type_Aswg;
  private atea jdField_a_of_type_Atea;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public atdz(BaseActivity paramBaseActivity, int paramInt, atea paramatea, aswg paramaswg)
  {
    super(paramBaseActivity, 2131755824);
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aswg = paramaswg;
    this.jdField_a_of_type_Atea = paramatea;
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
  
  private ater a(int paramInt, String paramString)
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
      str = localContext.getString(2131693473);
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
    for (paramString = localContext.getResources().getDrawable(2130845125);; paramString = localContext.getResources().getDrawable(2130845124))
    {
      paramInt = bhtq.a(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new ater();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      return paramString;
      str = localContext.getString(2131692060);
      break;
      paramString = str + " " + paramString;
      break label48;
      i = Color.parseColor("#33FF80BF");
      break label69;
      j = Color.parseColor("#FF80BF");
      break label81;
    }
  }
  
  private ater a(long paramLong)
  {
    int i = bhtq.a(11.0F);
    Object localObject1 = getContext().getResources().getDrawable(2130845126);
    ((Drawable)localObject1).setBounds(0, 0, i, i);
    Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
    String str = getContext().getString(2131693473);
    localObject1 = new SpannableString(str + " " + paramLong);
    ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
    localObject2 = new ater();
    ((ater)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
    ((ater)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
    ((ater)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
    return localObject2;
  }
  
  private void a()
  {
    setContentView(2131561208);
    if (this.jdField_a_of_type_Int == 1)
    {
      findViewById(2131367760).setVisibility(0);
      findViewById(2131377724).setVisibility(8);
      findViewById(2131377316).setOnClickListener(this);
    }
    Object localObject1;
    label647:
    do
    {
      for (;;)
      {
        findViewById(2131364585).setOnClickListener(this);
        localObject1 = findViewById(2131378801);
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
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131367760);
          ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131367760);
        }
        return;
        if (this.jdField_a_of_type_Int == 2)
        {
          findViewById(2131367760).setVisibility(8);
          findViewById(2131377724).setVisibility(0);
          findViewById(2131377026).setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131363109);
          this.jdField_a_of_type_Aoot = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Aswg.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Aoot);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          Object localObject2 = (TextView)findViewById(2131371805);
          if (this.jdField_a_of_type_Aswg.jdField_b_of_type_JavaLangString == null) {}
          Object localObject3;
          for (localObject1 = "";; localObject1 = this.jdField_a_of_type_Aswg.jdField_b_of_type_JavaLangString)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject1 = (TextView)findViewById(2131377059);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Aswg.d)) {
              break;
            }
            ((TextView)localObject1).setVisibility(8);
            ((TextView)findViewById(2131365623)).setText(String.format(getContext().getString(2131698079), new Object[] { atbg.a(this.jdField_a_of_type_Aswg.jdField_a_of_type_Int) }));
            localObject1 = getContext().getResources().getStringArray(2130968660);
            localObject2 = getContext().getResources().getStringArray(2130968659);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Aswg.jdField_b_of_type_Int, this.jdField_a_of_type_Aswg.e));
            if (this.jdField_a_of_type_Aswg.jdField_b_of_type_Long > 0L) {
              ((ArrayList)localObject3).add(a(this.jdField_a_of_type_Aswg.jdField_b_of_type_Long));
            }
            if (this.jdField_a_of_type_Aswg.jdField_a_of_type_JavaUtilArrayList == null) {
              break label647;
            }
            Iterator localIterator = this.jdField_a_of_type_Aswg.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!TextUtils.isEmpty(str))
              {
                ater localater = new ater();
                localater.jdField_a_of_type_JavaLangCharSequence = str;
                i = localater.jdField_a_of_type_JavaLangCharSequence.charAt(0);
                localater.jdField_b_of_type_Int = Color.parseColor(localObject1[(i % localObject1.length)]);
                localater.jdField_a_of_type_Int = Color.parseColor(localObject2[(i % localObject2.length)]);
                ((ArrayList)localObject3).add(localater);
              }
            }
          }
          ((TextView)localObject1).setVisibility(0);
          if (this.jdField_a_of_type_Aswg.a()) {}
          for (int i = 2130845178;; i = 2130845179)
          {
            localObject2 = getContext().getResources().getDrawable(i);
            i = bhtq.a(15.0F);
            ((Drawable)localObject2).setBounds(0, 0, i, i);
            localObject2 = new ImageSpan((Drawable)localObject2, 0);
            localObject3 = new SpannableString(" " + this.jdField_a_of_type_Aswg.d);
            ((SpannableString)localObject3).setSpan(localObject2, 0, " ".length(), 17);
            ((TextView)localObject1).setText((CharSequence)localObject3);
            break;
          }
          a((List)localObject3);
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131377724);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131377724);
    return;
    label681:
    ((View)localObject1).setVisibility(8);
  }
  
  public static void a(BaseActivity paramBaseActivity, aswg paramaswg, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing()) && (paramaswg != null))
    {
      paramBaseActivity = new atdz(paramBaseActivity, 2, null, paramaswg);
      paramBaseActivity.setOnDismissListener(paramOnDismissListener);
      paramBaseActivity.show();
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, atea paramatea)
  {
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      new atdz(paramBaseActivity, 1, paramatea, null).show();
    }
  }
  
  private void a(List<ater> paramList)
  {
    LabelLayout localLabelLayout1 = (LabelLayout)findViewById(2131369598);
    LabelLayout localLabelLayout2 = (LabelLayout)findViewById(2131369599);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298124);
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
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE97", "0X800AE97", 0, 0, "", "", "", "");
    c();
    dismiss();
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSignalBombDialog.1(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Aoot != null) {
      this.jdField_a_of_type_Aoot.b();
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AE98", "0X800AE98", 0, 0, "", "", "", "");
      QLog.d("ExtendFriendSignalBombDialog", 2, " closeBtn signal bomb dialog ");
      c();
      dismiss();
      continue;
      QLog.d("ExtendFriendSignalBombDialog", 2, " sendBtn signal bomb dialog ");
      c();
      dismiss();
      if (this.jdField_a_of_type_Atea != null)
      {
        this.jdField_a_of_type_Atea.a();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " sayHelloBtn signal bomb dialog ");
        b();
        continue;
        QLog.d("ExtendFriendSignalBombDialog", 2, " avatar signal bomb dialog ");
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_Aswg.jdField_a_of_type_JavaLangString, 96);
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
 * Qualified Name:     atdz
 * JD-Core Version:    0.7.0.1
 */