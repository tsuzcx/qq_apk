package com.tencent.mobileqq.activity.qwallet.fragment;

import aixz;
import aiyl;
import aizd;
import ajeu;
import alrk;
import alto;
import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdbk;
import bdgg;
import bdoo;
import bjcf;
import bjcm;
import bjcn;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ExclusiveHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected TextWatcher a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjcn jdField_a_of_type_Bjcn = new bjcn();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private String c = "";
  
  public ExclusiveHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new aixz(this);
  }
  
  private String a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label74;
      }
      try
      {
        localStringBuffer.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuffer.append("|");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    label74:
    return localStringBuffer.toString();
  }
  
  private ArrayList<ArrayList<String>> a(Intent paramIntent)
  {
    if (this.mActivity == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    QQAppInterface localQQAppInterface;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ResultRecord localResultRecord;
    Object localObject2;
    try
    {
      localQQAppInterface = (QQAppInterface)this.mActivity.getAppInterface();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      if (paramIntent == null) {
        return localArrayList1;
      }
      Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
      if (localObject1 != null)
      {
        paramIntent = (alto)this.mActivity.getAppInterface().getManager(51);
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localResultRecord = (ResultRecord)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty(localResultRecord.jdField_a_of_type_JavaLangString))
            {
              localArrayList2.add(localResultRecord.jdField_a_of_type_JavaLangString);
              if (TextUtils.isEmpty(localResultRecord.jdField_b_of_type_JavaLangString))
              {
                if (!this.jdField_a_of_type_JavaLangString.equals("1")) {
                  break;
                }
                localObject2 = paramIntent.e(localResultRecord.jdField_a_of_type_JavaLangString);
                if (localObject2 != null) {
                  localResultRecord.jdField_b_of_type_JavaLangString = ((Friends)localObject2).getFriendNick();
                }
              }
              if (!TextUtils.isEmpty(localResultRecord.jdField_b_of_type_JavaLangString))
              {
                localArrayList3.add(localResultRecord.jdField_b_of_type_JavaLangString);
                continue;
                return localArrayList1;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e("ExclusiveHbFragment", 1, paramIntent, new Object[0]);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangString.equals("2"))
      {
        localObject2 = ((alrk)localQQAppInterface.getManager(53)).a(this.jdField_b_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break;
        }
        localResultRecord.jdField_b_of_type_JavaLangString = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
        break;
      }
      if (!this.jdField_a_of_type_JavaLangString.equals("3")) {
        break;
      }
      localObject2 = bdgg.a().a(localQQAppInterface, this.jdField_b_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
      if (localObject2 == null) {
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark))
      {
        localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).autoremark;
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
      {
        localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).troopnick;
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick))
      {
        localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).friendnick;
        break;
      }
      localResultRecord.jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      break;
      localArrayList1.add(localArrayList2);
      localArrayList1.add(localArrayList3);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 2;
    b();
    e();
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    bjcm.a(paramBundle, this.jdField_a_of_type_Bjcn);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjcn.recv_type;
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("recv_uin");
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362556));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363546));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131365859));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378832));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369617));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(aizd.a(this.channel, this.jdField_a_of_type_Bjcn, this.mActivity.a(), alud.a(2131704621)));
    paramView.findViewById(2131368740).setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.i("ExclusiveHbFragment", 2, "bizParams:" + this.jdField_a_of_type_Bjcn.biz_params);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697240));
    }
  }
  
  private void b()
  {
    int i;
    label40:
    TextView localTextView;
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 2130846697;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Int != 1) {
        break label105;
      }
      i = 2131697233;
      ((TextView)localObject).setText(i);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Int != 1) {
        break label112;
      }
    }
    label105:
    label112:
    for (Object localObject = alud.a(2131704624) + getString(2131697233);; localObject = alud.a(2131704616) + getString(2131697232))
    {
      localTextView.setContentDescription((CharSequence)localObject);
      d();
      return;
      i = 2130846696;
      break;
      i = 2131697232;
      break label40;
    }
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Map localMap = this.mActivity.a();
    String str;
    try
    {
      str = a(this.jdField_a_of_type_JavaUtilArrayList);
      if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (TextUtils.isEmpty(str)))
      {
        this.mActivity.c(alud.a(2131704620));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ExclusiveHbFragment", 1, localException, new Object[0]);
      return;
    }
    localException.put("grab_uin_list", str);
    this.c = String.valueOf(a());
    combineUploadData(this.jdField_a_of_type_Bjcn, this.channel, this.jdField_b_of_type_Int, bjcf.a(this.c), "only.wrappacket.wrap");
    localException.put("type", String.valueOf(1));
    localException.put("wishing", aizd.a(this.jdField_b_of_type_AndroidWidgetEditText));
    localException.put("bus_type", this.jdField_a_of_type_Int + "");
    localException.put("total_num", this.jdField_b_of_type_Int + "");
    localException.put("total_amount", bjcf.a(this.c));
    localException.put("channel", String.valueOf(this.channel));
    this.mLogic.a(localException);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
    {
      a(false);
      return;
    }
    this.c = String.valueOf(a());
    a(true);
    String str = getString(2131697240) + this.c + alud.a(2131704619);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str);
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(alud.a(2131704617));
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(alud.a(2131704618));
    localTextView.setSingleLine();
    localTextView.setTextSize(15.0F);
    localTextView.setTextColor(getActivity().getResources().getColor(2131166120));
    ajeu.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0.6F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
    d();
  }
  
  protected float a()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f2 = bjcf.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    float f1 = f2;
    if (this.jdField_a_of_type_Int == 1) {
      f1 = f2 * this.jdField_b_of_type_Int;
    }
    return f1;
  }
  
  public void a(ArrayList<ArrayList<String>> paramArrayList)
  {
    if ((isDetached()) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    ArrayList localArrayList;
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      localArrayList = (ArrayList)paramArrayList.get(0);
      paramArrayList = (ArrayList)paramArrayList.get(1);
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        int j = localArrayList.size();
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              String str = (String)localArrayList.get(i);
              ImageView localImageView = new ImageView(getActivity());
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bdoo.b(32.0F), bdoo.b(32.0F));
              localLayoutParams.setMargins(-bdoo.a(5.0F), 0, 0, 0);
              localImageView.setLayoutParams(localLayoutParams);
              localImageView.setImageDrawable(bdbk.a((QQAppInterface)getActivity().getAppRuntime(), 1, str));
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          while (i < paramArrayList.size())
          {
            if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i))) {
              localStringBuffer.append((String)paramArrayList.get(i));
            }
            localStringBuffer.append(" ,");
            i += 1;
          }
        }
        if (!TextUtils.isEmpty(localStringBuffer)) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(alud.a(2131704623) + j + alud.a(2131704622) + localStringBuffer.toString());
        }
        d();
        return;
      }
      e();
      return;
      paramArrayList = null;
      localArrayList = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1) && (paramIntent != null)) {
      a(a(paramIntent));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      return;
      this.mActivity.c("only.wrappacket.wrap");
      c();
      return;
      if (this.jdField_a_of_type_Int == 1) {}
      for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 1)
      {
        b();
        return;
      }
      l = System.currentTimeMillis();
    } while (this.jdField_a_of_type_Long + 1200L > l);
    this.jdField_a_of_type_Long = l;
    this.mActivity.a(this.jdField_a_of_type_Bjcn.recv_type, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561717, null);
    a(paramLayoutInflater, getArguments());
    a();
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("ExclusiveHbFragment", 2, "ExclusiveHb enter...");
      if (this.mActivity != null) {
        this.mActivity.c("only.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ExclusiveHbFragment
 * JD-Core Version:    0.7.0.1
 */