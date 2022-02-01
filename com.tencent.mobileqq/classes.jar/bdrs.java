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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class bdrs
  extends bdom
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#8C6CF5"));
  static HashMap<Integer, ColorDrawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public int s = -1;
  
  protected int b()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    View localView;
    bdru localbdru;
    label223:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131560679, null);
      localbdru = new bdru(this);
      localbdru.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localView.findViewById(2131363405));
      localbdru.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localbdru.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377937));
      localbdru.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377855));
      localbdru.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378992));
      localbdru.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377854));
      localView.setTag(this.s, localbdru);
      localView.setOnClickListener(this);
      paramBundle = (ColorDrawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.p));
      paramView = paramBundle;
      if (paramBundle == null)
      {
        paramView = paramBundle;
        if (this.p != 0)
        {
          paramView = new ColorDrawable(this.p);
          jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.p), paramView);
        }
      }
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      localbdru.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBundle);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = null;
      paramBundle = (Bundle)localObject1;
      if (!localIterator.hasNext()) {
        break label512;
      }
      localObject1 = (bdol)localIterator.next();
      localObject2 = ((bdol)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label346;
      }
      localObject2 = (StructMsgItemTitle)localObject1;
      localbdru.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTitle)localObject2).ai);
      label282:
      if (!TextUtils.isEmpty(paramView)) {
        break label608;
      }
      localObject1 = (StructMsgForGeneralShare)((bdol)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      paramView = ((StructMsgForGeneralShare)localObject1).animResId;
      paramBundle = ((StructMsgForGeneralShare)localObject1).atMembers;
      localbdru.c = String.valueOf(((StructMsgForGeneralShare)localObject1).uniseq);
    }
    label346:
    label608:
    for (;;)
    {
      for (;;)
      {
        break label223;
        localbdru = (bdru)paramView.getTag(this.s);
        localView = paramView;
        break;
        if (!"picture".equals(localObject2)) {
          break label460;
        }
        localObject2 = ((bdqo)localObject1).ac;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label282;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)bhmg.a(paramContext, 62.5F));
          localURLDrawableOptions.mRequestHeight = ((int)bhmg.a(paramContext, 115.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          localbdru.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          localbdru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
          localbdru.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      break label282;
      if (!"voice".equals(localException)) {
        break label282;
      }
      bdqb localbdqb = (bdqb)localObject1;
      localbdru.jdField_a_of_type_AndroidWidgetTextView.setText(localbdqb.o + "\"");
      break label282;
      localbdru.jdField_a_of_type_JavaLangString = paramView;
      localbdru.jdField_b_of_type_JavaLangString = paramBundle;
      if (bgkf.a().b(localbdru.c))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)paramContext.getResources().getDrawable(2130843858));
        }
        localbdru.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        }
        return localView;
      }
      localbdru.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843857);
      return localView;
    }
  }
  
  public String b()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(this.s);
    if ((localObject instanceof bdru))
    {
      localObject = (bdru)localObject;
      if (!TextUtils.isEmpty(((bdru)localObject).jdField_a_of_type_JavaLangString)) {
        break label48;
      }
      QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      String str1 = ((bdru)localObject).jdField_a_of_type_JavaLangString;
      String str2 = ((bdru)localObject).c;
      bgkf localbgkf = bgkf.a();
      if (localbgkf.a(((bdru)localObject).jdField_a_of_type_JavaLangString)) {
        bgkf.a().a(str2, ((bdru)localObject).jdField_a_of_type_JavaLangString, ((bdru)localObject).jdField_b_of_type_JavaLangString);
      } else {
        localbgkf.a(((bdru)localObject).jdField_a_of_type_JavaLangString, new bdrt(this, str2, str1, (bdru)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrs
 * JD-Core Version:    0.7.0.1
 */