import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;

class baoy
  extends bapb
{
  baoy(baov parambaov)
  {
    super(parambaov);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560295, null);
    }
    baoz localbaoz = (baoz)localView3.getTag();
    if (localbaoz == null)
    {
      localbaoz = new baoz(this);
      localbaoz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131371608));
      localbaoz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131377350));
      localbaoz.b = ((TextView)localView3.findViewById(2131364692));
      localbaoz.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361821));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbaoz);
    }
    for (;;)
    {
      localbaoz.jdField_a_of_type_Int = paramInt;
      localbaoz.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbaoz.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbaoz.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbaoz.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbaoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbaoz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbaoz.b.setVisibility(0);
      localbaoz.b.setSingleLine(false);
      localbaoz.b.setMaxLines(2);
      localbaoz.b.setText("");
      localbaoz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbaoz.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = ajyc.a(2131715310) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843024);
        }
        paramView = this.a.b;
        if (bbjw.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = actn.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          Object localObject;
          if (!paramTroopFeedItem.isStoryType())
          {
            localObject = str;
            if (paramTroopFeedItem.type != 5)
            {
              localObject = str;
              if (paramTroopFeedItem.type != 19)
              {
                localObject = str;
                if (paramTroopFeedItem.type == 99) {}
              }
            }
          }
          else
          {
            paramView = str;
            if (!bbjw.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbaoz.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370832)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bbjw.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = ajyc.a(2131715313) + azor.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbaoz.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361820)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbaoz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbaoz.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(apue.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + ajyc.a(2131715314);
                }
                localView3.setContentDescription(paramTroopFeedItem);
                return localView3;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localView2 = paramView;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + paramTroopFeedItem.feedTime);
                localView2 = paramView;
              }
              if (paramTroopFeedItem.type == 132)
              {
                if (this.a.c == null) {
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843026);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843024);
              }
              paramView = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          View localView2;
          paramInt = 0;
          continue;
          if ((paramTroopFeedItem.type == 5) || (paramTroopFeedItem.type == 19))
          {
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbaoz.b.setText(paramTroopFeedItem.content);
            localbaoz.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbaoz.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843029);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843028);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbaoz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbaoz.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(ajyc.a(2131715307)))
          {
            localbaoz.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbaoz.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
          }
          paramView = localView2 + " " + paramTroopFeedItem.content;
          continue;
        }
        label1164:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baoy
 * JD-Core Version:    0.7.0.1
 */