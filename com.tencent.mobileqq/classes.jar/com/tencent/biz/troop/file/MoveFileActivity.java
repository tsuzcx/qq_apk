package com.tencent.biz.troop.file;

import actn;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import axqw;
import azpg;
import bajk;
import bakj;
import bcpq;
import bfpc;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import xag;
import xah;
import xai;
import xaj;
import xak;
import xal;
import xam;
import xan;
import xap;
import xar;
import xav;
import xnm;

public class MoveFileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bfpc
{
  public int a;
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bajk jdField_a_of_type_Bajk;
  private bcpq jdField_a_of_type_Bcpq;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFromUtf8("");
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private ArrayList<azpg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private xan jdField_a_of_type_Xan = new xan(this, null);
  private xar jdField_a_of_type_Xar = new xam(this);
  private xav jdField_a_of_type_Xav = new xai(this);
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 15;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int e;
  
  public MoveFileActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", MoveFileActivity.class.getName());
    localIntent.putExtra("troop_uin", paramString1);
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "/";
    }
    localIntent.putExtra("folder_id", paramContext);
    localIntent.putExtra("file_id", paramString3);
    localIntent.putExtra("file_name", paramString4);
    return localIntent;
  }
  
  private boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_JavaLangString.equals("/")) || (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void c()
  {
    a();
  }
  
  public void a()
  {
    xap.a(this.app, this.jdField_a_of_type_Long, this.jdField_d_of_type_Int, 0, this.jdField_c_of_type_Int, 3, 1, "/", 1, 0L, this.e, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_Xav);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bcpq == null) {
        this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bcpq.c(paramInt);
      this.jdField_a_of_type_Bcpq.c(false);
      this.jdField_a_of_type_Bcpq.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarActivity", 2, localException.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = xnm.a(this, paramString1, "", 2131690596, 2131691035, new xaj(this), new xak(this));
    paramString2 = paramString1.getEditText();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.setText(paramString3);
    }
    paramString2.setFilters(new InputFilter[] { new InputFilter.LengthFilter(48) });
    paramString2.setHint(2131697856);
    paramString2.addTextChangedListener(new xal(this, paramString2, paramString1));
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.a(paramString4, -65536);
    }
    paramString1.getBtnight().setEnabled(false);
    paramString1.getBtnight().setTextColor(getResources().getColor(2131165540));
    paramString1.show();
    new Handler(getMainLooper()).post(new MoveFileActivity.7(this, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719790);
    Drawable localDrawable = getResources().getDrawable(2130839140);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarActivity", 2, localException.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    Object localObject = paramBundle.getString("troop_uin");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Long = Long.valueOf((String)localObject).longValue();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("folder_id");
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("file_name");
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("file_id");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Bajk = bajk.a(this.app, this.jdField_a_of_type_Long);
    paramBundle = (LayoutInflater)getSystemService("layout_inflater");
    localObject = paramBundle.inflate(2131560329, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131364566));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131364832);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131364611));
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setContentView((View)localObject);
    setTitle(2131697846);
    localTextView = (TextView)findViewById(2131368457);
    localTextView.setText(2131690596);
    localTextView.setOnClickListener(this);
    localTextView.setVisibility(0);
    this.leftView.setVisibility(8);
    localObject = (TextView)((View)localObject).findViewById(2131366249);
    TextUtils.ellipsize(this.jdField_d_of_type_JavaLangString, ((TextView)localObject).getPaint(), actn.a(230.0F, getResources()), TextUtils.TruncateAt.MIDDLE, false, new xag(this, (TextView)localObject));
    this.jdField_a_of_type_AndroidViewView = paramBundle.inflate(2131560334, null);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131372724).setBackgroundResource(2130838514);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372725));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166854));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Xan);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xan);
    c();
    axqw.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_file", 0, 0, Long.toString(this.jdField_a_of_type_Long), "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      axqw.b(this.app, "P_CliOper", "Grp_files", "", "file", "move_cancel", 0, 0, Long.toString(this.jdField_a_of_type_Long), "", "", "");
      finish();
      overridePendingTransition(0, 2130772001);
      return;
      if (bakj.a(this.app, this, this.jdField_a_of_type_Long) != 0)
      {
        a(getResources().getString(2131697782), null, this.jdField_a_of_type_JavaLangString, "");
        return;
        paramView = (azpg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
        if (this.jdField_b_of_type_JavaLangString.equals(paramView.jdField_b_of_type_JavaLangString))
        {
          finish();
          overridePendingTransition(0, 2130772001);
          return;
        }
        try
        {
          if (bakj.a(this.app, this, this.jdField_a_of_type_Long) != 0)
          {
            xap.a(this.app, this.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString, new xah(this, paramView));
            a(2131697847);
            return;
          }
        }
        catch (NumberFormatException paramView) {}
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839047);
    this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(getActivity(), 2131755329);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Xan.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity
 * JD-Core Version:    0.7.0.1
 */