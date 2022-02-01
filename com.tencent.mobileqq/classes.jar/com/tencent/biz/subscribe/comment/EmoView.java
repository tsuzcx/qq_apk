package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class EmoView
  extends LinearLayout
  implements KeyClickListener, WorkSpaceView.OnScreenChangeListener
{
  private int jdField_a_of_type_Int = 2130839206;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private EmoView.EmoClickListener jdField_a_of_type_ComTencentBizSubscribeCommentEmoView$EmoClickListener;
  private WorkSpaceView.OnScreenChangeListener jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener;
  private WorkSpaceView jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean[] jdField_a_of_type_ArrayOfBoolean = { 1, 0, 0, 0 };
  private int jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  private EmoView.EmoClickListener jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$EmoClickListener = new EmoView.4(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int c = 28;
  private int d = 1;
  private int e = -1;
  
  public EmoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView = new WorkSpaceView(getContext());
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setOnScreenChangeListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 81;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidOsHandler = new EmoView.1(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setHandler(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 81;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 13, 0, 13);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    super.addView(this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView);
    super.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private static void a(EditText paramEditText, int paramInt, String paramString)
  {
    paramEditText.getText().insert(paramInt, paramString);
    String str = paramEditText.getText().toString();
    if (paramString.length() + paramInt > str.length())
    {
      paramEditText.setSelection(str.length());
      return;
    }
    paramEditText.setSelection(paramString.length() + paramInt);
  }
  
  public static void a(EditText paramEditText, String paramString)
  {
    int i = paramEditText.getSelectionStart();
    if (i >= paramEditText.length()) {
      try
      {
        paramEditText.append(paramString);
        return;
      }
      catch (Exception localException)
      {
        a(paramEditText, i, paramString);
        return;
      }
    }
    a(paramEditText, i, paramString);
  }
  
  private void b(int paramInt)
  {
    int i = 27;
    int j = (int)Math.ceil(107.0D / (27 * 1.0D));
    GridView localGridView = (GridView)LayoutInflater.from(getContext()).inflate(2131558878, null);
    localGridView.setNumColumns(7);
    if (paramInt == j) {
      i = 26;
    }
    EmoWindowAdapter localEmoWindowAdapter = new EmoWindowAdapter(getContext(), paramInt, i, 28, paramInt, this);
    localGridView.setAdapter(localEmoWindowAdapter);
    localGridView.setColumnWidth(this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getWidth() / 7);
    localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(196.0F)));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView.addView(localGridView);
    postDelayed(new EmoView.2(this, paramInt, localGridView, localEmoWindowAdapter), 1000L);
    localGridView.setOnItemClickListener(new EmoView.3(this, paramInt));
  }
  
  private void c(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setSelected(false);
      i += 1;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localView != null) {
      localView.setSelected(true);
    }
  }
  
  public void a(int paramInt)
  {
    this.d = (paramInt + 1);
    c(paramInt);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 27) {
      this.jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$EmoClickListener.a();
    }
    do
    {
      return;
      paramInt1 = (paramInt2 - 1) * 27 + paramInt1;
    } while (paramInt1 >= 107);
    String str = Patterns.b[EmoWindowAdapter.b[paramInt1]];
    this.jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$EmoClickListener.a(str);
  }
  
  public void setNavgationVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$OnScreenChangeListener = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView
 * JD-Core Version:    0.7.0.1
 */