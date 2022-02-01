import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter.3;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class astb
  extends RecyclerView.Adapter<aste>
  implements View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  protected asmr a;
  private assw jdField_a_of_type_Assw;
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString = "";
  private List<aspq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  
  public astb(QQAppInterface paramQQAppInterface, Context paramContext, asmr paramasmr)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asmr = paramasmr;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Int = bhtq.a();
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private URLImageView a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RelatedEmoticonListAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.jdField_b_of_type_Int - 2.0F * this.jdField_a_of_type_Float * (this.jdField_a_of_type_Int - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.jdField_a_of_type_Int, i / this.jdField_a_of_type_Int);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691094));
      return localURLImageView;
      if (paramInt == this.jdField_a_of_type_Int - 1)
      {
        localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
        localLayoutParams.rightMargin = 0;
        localLayoutParams.width = -1;
      }
      else
      {
        localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
        localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 1.0F));
      }
    }
  }
  
  private void a(View paramView, aspq paramaspq, int paramInt)
  {
    if ((paramView == null) || (!(paramaspq instanceof assw))) {
      QLog.e("RelatedEmoticonListAdapter", 1, "emotionInfo or contentView = null");
    }
    String str1;
    String str2;
    int i;
    do
    {
      URLImageView localURLImageView;
      asmu localasmu;
      do
      {
        return;
        str1 = ((assw)paramaspq).jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString;
        str2 = ((assw)paramaspq).jdField_a_of_type_Astj.b;
        i = ((assw)paramaspq).jdField_a_of_type_Int;
        localURLImageView = (URLImageView)paramView;
        localasmu = (asmu)paramaspq;
        paramView.setTag(localasmu);
        paramView.setVisibility(0);
        if ((QLog.isColorLevel()) && (!bhsr.a(localasmu.i))) {
          QLog.d("RelatedEmoticonListAdapter", 2, "updateUI info = " + localasmu.i);
        }
      } while (localURLImageView.getTag(2131381109) == paramaspq);
      localURLImageView.setOnClickListener(new astc(this, localasmu));
      localURLImageView.setFocusable(true);
      localURLImageView.setOnLongClickListener(this);
      localURLImageView.setTag(2131381109, paramaspq);
      localURLImageView.setVisibility(0);
      localURLImageView.setURLDrawableDownListener(null);
      paramView = localasmu.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      if ((paramView instanceof URLDrawable)) {
        localURLImageView.setURLDrawableDownListener(new astd(this, localasmu));
      }
      localURLImageView.setImageDrawable(paramView);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B116", "0X800B116", asos.a(this.c), 0, "", paramInt + 1 + "", str1, str2);
    } while (i <= 0);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B11D", "0X800B11D", i, 0, "", paramInt + 1 + "", str1, str2);
  }
  
  private void a(asmu paramasmu)
  {
    if ((this.jdField_a_of_type_Asmr != null) && (paramasmu != null)) {
      this.jdField_a_of_type_Asmr.a(paramasmu);
    }
  }
  
  private void a(String paramString)
  {
    File localFile = beqz.a(paramString);
    if ((localFile == null) || (!localFile.exists()))
    {
      QLog.e("RelatedEmoticonListAdapter", 4, " add custom fail file no exist");
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)bcry.a(-2000);
    localMessageForPic.path = localFile.getAbsolutePath();
    localMessageForPic.md5 = bhml.a(MD5.getFileMd5(localMessageForPic.path));
    localMessageForPic.thumbMsgUrl = paramString;
    localMessageForPic.bigMsgUrl = paramString;
    localMessageForPic.imageType = 2000;
    paramString = beyq.a(paramString);
    paramString.setTag(localMessageForPic);
    aicv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011), null, localMessageForPic.picExtraData);
  }
  
  @NonNull
  public aste a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new aste(this.jdField_a_of_type_AndroidViewView);
    }
    if (paramInt == 2) {
      return new aste(this.jdField_b_of_type_AndroidViewView);
    }
    return new aste(new RelatedEmoLinearLayout(paramViewGroup.getContext()));
  }
  
  public List<aspq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131362195);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167302));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692954));
    ((TextView)localObject).setBackgroundResource(2130838924);
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(bhtq.a(65.0F), bhtq.a(46.0F)));
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838920));
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(bhtq.a(20.0F), bhtq.a(10.0F)));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    localLayoutParams.topMargin = (-agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams.bottomMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localLinearLayout, -2, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(this);
    localLinearLayout.measure(0, 0);
    paramView.post(new RelatedEmoticonListAdapter.3(this, paramView, localLinearLayout));
  }
  
  public void a(@Nullable View paramView1, @Nullable View paramView2, List<aspq> paramList)
  {
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(@NonNull aste paramaste, int paramInt)
  {
    int j = 0;
    if (paramaste.getItemViewType() != 3) {
      j = paramInt;
    }
    int i;
    do
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaste, j, getItemId(j));
      return;
      i = paramInt;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        i = paramInt - 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RelatedEmoticonListAdapter", 2, "getEmotionView position = " + i + "; view from inflater");
      }
      LinearLayout localLinearLayout = (LinearLayout)paramaste.itemView;
      localLinearLayout.setFocusable(false);
      localLinearLayout.setClickable(false);
      localLinearLayout.setDescendantFocusability(262144);
      localLinearLayout.setFocusableInTouchMode(false);
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(0, bhtq.a(2.0F), 0, 0);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_Int)
      {
        URLImageView localURLImageView = a(paramInt);
        localURLImageView.setVisibility(8);
        localURLImageView.setFocusable(true);
        localURLImageView.setFocusableInTouchMode(true);
        localLinearLayout.addView(localURLImageView);
        paramInt += 1;
      }
      paramaste.a = new URLImageView[this.jdField_a_of_type_Int];
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_Int)
      {
        paramaste.a[paramInt] = ((URLImageView)localLinearLayout.getChildAt(paramInt));
        paramInt += 1;
      }
      localLinearLayout.setTag(paramaste);
      paramInt = j;
      j = i;
    } while (paramInt >= this.jdField_a_of_type_Int);
    j = this.jdField_a_of_type_Int * i + paramInt;
    if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      paramaste.a[paramInt].setTag(null);
      paramaste.a[paramInt].setVisibility(8);
    }
    for (;;)
    {
      paramInt += 1;
      break;
      a(paramaste.a[paramInt], (aspq)this.jdField_a_of_type_JavaUtilList.get(j), j);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public void a(List<aspq> paramList)
  {
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView, paramList);
  }
  
  public int getItemCount()
  {
    int k = 1;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int m = this.jdField_a_of_type_JavaUtilList.size();
      j = m / this.jdField_a_of_type_Int;
      i = j;
      if (m % this.jdField_a_of_type_Int <= 0) {}
    }
    for (int i = j + 1;; i = 0)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        j = 1;
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break label71;
        }
      }
      for (;;)
      {
        return i + j + k;
        j = 0;
        break;
        label71:
        k = 0;
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 1;
    }
    if ((paramInt == getItemCount() - 1) && (this.jdField_b_of_type_AndroidViewView != null)) {
      return 2;
    }
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362195)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RelatedEmoticonListAdapter", 4, " add_to_custom_face ");
      }
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break label50;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      if (this.jdField_a_of_type_Assw != null)
      {
        a(this.jdField_a_of_type_Assw.jdField_a_of_type_Astj.b);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B119", "0X800B119", 0, 0, "", this.jdField_a_of_type_Assw.jdField_b_of_type_Int + 1 + "", this.jdField_a_of_type_Assw.jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Assw.jdField_a_of_type_Astj.b);
        this.jdField_a_of_type_Assw = null;
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_a_of_type_Assw = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!(paramView instanceof URLImageView)) {}
    do
    {
      return false;
      a(paramView);
      this.jdField_a_of_type_Assw = ((assw)paramView.getTag(2131381109));
    } while (this.jdField_a_of_type_Assw == null);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B118", "0X800B118", 0, 0, "", this.jdField_a_of_type_Assw.jdField_b_of_type_Int + 1 + "", this.jdField_a_of_type_Assw.jdField_a_of_type_Astj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Assw.jdField_a_of_type_Astj.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astb
 * JD-Core Version:    0.7.0.1
 */