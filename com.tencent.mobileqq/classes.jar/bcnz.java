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

class bcnz
  extends bcoc
{
  bcnz(bcnw parambcnw)
  {
    super(parambcnw);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560403, null);
    }
    bcoa localbcoa = (bcoa)localView3.getTag();
    if (localbcoa == null)
    {
      localbcoa = new bcoa(this);
      localbcoa.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131371925));
      localbcoa.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131377884));
      localbcoa.b = ((TextView)localView3.findViewById(2131364770));
      localbcoa.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361820));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbcoa);
    }
    for (;;)
    {
      localbcoa.jdField_a_of_type_Int = paramInt;
      localbcoa.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbcoa.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbcoa.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbcoa.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbcoa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbcoa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbcoa.b.setVisibility(0);
      localbcoa.b.setSingleLine(false);
      localbcoa.b.setMaxLines(2);
      localbcoa.b.setText("");
      localbcoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbcoa.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = alpo.a(2131715693) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843209);
        }
        paramView = this.a.b;
        if (bdje.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = aekt.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!bdje.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbcoa.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371142)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bdje.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = alpo.a(2131715696) + bbnc.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbcoa.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361819)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbcoa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbcoa.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(arni.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + alpo.a(2131715697);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843211);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843209);
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
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbcoa.b.setText(paramTroopFeedItem.content);
            localbcoa.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbcoa.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843214);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843213);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbcoa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbcoa.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(alpo.a(2131715690)))
          {
            localbcoa.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbcoa.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnz
 * JD-Core Version:    0.7.0.1
 */