import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class aztq
  extends azqk
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#8C6CF5"));
  static HashMap<Integer, ColorDrawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public int o = -1;
  
  protected int b()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    View localView;
    azts localazts;
    label223:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131560512, null);
      localazts = new azts(this);
      localazts.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localView.findViewById(2131363194));
      localazts.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localazts.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376924));
      localazts.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376839));
      localazts.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377934));
      localazts.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376838));
      localView.setTag(this.o, localazts);
      localView.setOnClickListener(this);
      paramBundle = (ColorDrawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.l));
      paramView = paramBundle;
      if (paramBundle == null)
      {
        paramView = paramBundle;
        if (this.l != 0)
        {
          paramView = new ColorDrawable(this.l);
          jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.l), paramView);
        }
      }
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      localazts.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBundle);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = null;
      paramBundle = (Bundle)localObject1;
      if (!localIterator.hasNext()) {
        break label512;
      }
      localObject1 = (azqj)localIterator.next();
      localObject2 = ((azqj)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label346;
      }
      localObject2 = (StructMsgItemTitle)localObject1;
      localazts.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTitle)localObject2).Y);
      label282:
      if (!TextUtils.isEmpty(paramView)) {
        break label608;
      }
      localObject1 = (StructMsgForGeneralShare)((azqj)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      paramView = ((StructMsgForGeneralShare)localObject1).animResId;
      paramBundle = ((StructMsgForGeneralShare)localObject1).atMembers;
      localazts.c = String.valueOf(((StructMsgForGeneralShare)localObject1).uniseq);
    }
    label346:
    label608:
    for (;;)
    {
      for (;;)
      {
        break label223;
        localazts = (azts)paramView.getTag(this.o);
        localView = paramView;
        break;
        if (!"picture".equals(localObject2)) {
          break label460;
        }
        localObject2 = ((azsm)localObject1).S;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label282;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)bdcq.a(paramContext, 62.5F));
          localURLDrawableOptions.mRequestHeight = ((int)bdcq.a(paramContext, 115.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          localazts.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          localazts.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
          localazts.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      break label282;
      if (!"voice".equals(localException)) {
        break label282;
      }
      azrz localazrz = (azrz)localObject1;
      localazts.jdField_a_of_type_AndroidWidgetTextView.setText(localazrz.k + "\"");
      break label282;
      localazts.jdField_a_of_type_JavaLangString = paramView;
      localazts.jdField_b_of_type_JavaLangString = paramBundle;
      if (bcdy.a().b(localazts.c))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)paramContext.getResources().getDrawable(2130843466));
        }
        localazts.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        }
        return localView;
      }
      localazts.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843465);
      return localView;
    }
  }
  
  public String b()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag(this.o);
    if ((paramView instanceof azts))
    {
      paramView = (azts)paramView;
      if (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) {
        QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
      }
    }
    else
    {
      return;
    }
    String str1 = paramView.jdField_a_of_type_JavaLangString;
    String str2 = paramView.c;
    bcdy localbcdy = bcdy.a();
    if (localbcdy.a(paramView.jdField_a_of_type_JavaLangString))
    {
      bcdy.a().a(str2, paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString);
      return;
    }
    localbcdy.a(paramView.jdField_a_of_type_JavaLangString, new aztr(this, str2, str1, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztq
 * JD-Core Version:    0.7.0.1
 */