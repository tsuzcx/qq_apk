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

class bgxb
  extends bgxe
{
  bgxb(bgwy parambgwy)
  {
    super(parambgwy);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560572, null);
    }
    bgxc localbgxc = (bgxc)localView3.getTag();
    if (localbgxc == null)
    {
      localbgxc = new bgxc(this);
      localbgxc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131372628));
      localbgxc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131378936));
      localbgxc.b = ((TextView)localView3.findViewById(2131365046));
      localbgxc.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361821));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbgxc);
    }
    for (;;)
    {
      localbgxc.jdField_a_of_type_Int = paramInt;
      localbgxc.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbgxc.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbgxc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbgxc.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbgxc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbgxc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbgxc.b.setVisibility(0);
      localbgxc.b.setSingleLine(false);
      localbgxc.b.setMaxLines(2);
      localbgxc.b.setText("");
      localbgxc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbgxc.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = anzj.a(2131714095) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843601);
        }
        paramView = this.a.b;
        if (bhsr.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = agej.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!bhsr.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbgxc.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371827)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bhsr.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = anzj.a(2131714098) + bfrd.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbgxc.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361820)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbgxc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbgxc.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(aunj.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + anzj.a(2131714099);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843603);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843601);
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
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbgxc.b.setText(paramTroopFeedItem.content);
            localbgxc.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbgxc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843606);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843605);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbgxc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbgxc.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(anzj.a(2131714092)))
          {
            localbgxc.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbgxc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxb
 * JD-Core Version:    0.7.0.1
 */