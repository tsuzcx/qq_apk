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

class bcsi
  extends bcsl
{
  bcsi(bcsf parambcsf)
  {
    super(parambcsf);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560402, null);
    }
    bcsj localbcsj = (bcsj)localView3.getTag();
    if (localbcsj == null)
    {
      localbcsj = new bcsj(this);
      localbcsj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131371945));
      localbcsj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131377938));
      localbcsj.b = ((TextView)localView3.findViewById(2131364771));
      localbcsj.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361820));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbcsj);
    }
    for (;;)
    {
      localbcsj.jdField_a_of_type_Int = paramInt;
      localbcsj.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbcsj.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbcsj.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbcsj.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbcsj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbcsj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbcsj.b.setVisibility(0);
      localbcsj.b.setSingleLine(false);
      localbcsj.b.setMaxLines(2);
      localbcsj.b.setText("");
      localbcsj.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbcsj.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = alud.a(2131715705) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843222);
        }
        paramView = this.a.b;
        if (bdnn.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = aepi.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!bdnn.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbcsj.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371161)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bdnn.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = alud.a(2131715708) + bbrl.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbcsj.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361819)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbcsj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbcsj.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(arrr.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + alud.a(2131715709);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843224);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843222);
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
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbcsj.b.setText(paramTroopFeedItem.content);
            localbcsj.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbcsj.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843227);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843226);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbcsj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbcsj.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(alud.a(2131715702)))
          {
            localbcsj.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbcsj.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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
 * Qualified Name:     bcsi
 * JD-Core Version:    0.7.0.1
 */