package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import rcf;
import rcg;

public class ReadInJoyDisLikeDialogView
  extends FrameLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected Boolean a;
  protected ArrayList<DislikeInfo> a;
  protected rcf a;
  protected rcg a;
  protected int[] a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private RelativeLayout b;
  protected ArrayList<DislikeInfo> b;
  protected int[] b;
  
  public ReadInJoyDisLikeDialogView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131378636, 2131378637, 2131378638, 2131378639, 2131378640, 2131378641, 2131378642, 2131378643 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131378631, 2131378632, 2131378633, 2131378634 };
    a(paramContext);
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i >= this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      i = this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length;
      j = 0;
      label25:
      if (j >= i) {
        break label117;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a)) {
        break label81;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
      break label25;
      break;
      label81:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a);
    }
    label117:
    int j = i;
    if (j < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].getVisibility() == 8) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(0);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rcg = null;
    this.jdField_a_of_type_Rcf = null;
  }
  
  protected void a(Context paramContext)
  {
    int j = 0;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559823, this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378629));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131167134));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378647));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378644));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131699672));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378626));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378628));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#FFF6F7FA"));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[this.jdField_a_of_type_ArrayOfInt.length];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i]));
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setOnClickListener(this);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[this.jdField_b_of_type_ArrayOfInt.length];
    i = j;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    case 2131378627: 
    default: 
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfInt.length) {
        if (paramView.getId() != this.jdField_a_of_type_ArrayOfInt[i]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        if (!this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected()) {
          break label176;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      for (;;)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) {
          break label253;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        do
        {
          return;
        } while ((this.jdField_a_of_type_Rcg != null) && (!this.jdField_a_of_type_Rcg.a(paramView, this.jdField_b_of_type_JavaUtilArrayList, null)));
        a();
        return;
        if (this.jdField_a_of_type_Rcf != null) {
          this.jdField_a_of_type_Rcf.a();
        }
        a();
        return;
        i += 1;
        break;
        label176:
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          paramView = this.jdField_a_of_type_ArrayOfAndroidWidgetButton;
          int k = paramView.length;
          int j = 0;
          while (j < k)
          {
            paramView[j].setSelected(false);
            j += 1;
          }
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      label253:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      i = -1;
    }
  }
  
  public void setOnComplainListener(rcf paramrcf)
  {
    this.jdField_a_of_type_Rcf = paramrcf;
  }
  
  public void setOnUninterestConfirmListener(rcg paramrcg)
  {
    this.jdField_a_of_type_Rcg = paramrcg;
  }
  
  public void setUninterestData(ArrayList<DislikeInfo> paramArrayList)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label60;
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      b();
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
      label60:
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView
 * JD-Core Version:    0.7.0.1
 */