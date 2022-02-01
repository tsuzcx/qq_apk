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

class bfxa
  extends bfxd
{
  bfxa(bfwx parambfwx)
  {
    super(parambfwx);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560557, null);
    }
    bfxb localbfxb = (bfxb)localView3.getTag();
    if (localbfxb == null)
    {
      localbfxb = new bfxb(this);
      localbfxb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131372517));
      localbfxb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131378776));
      localbfxb.b = ((TextView)localView3.findViewById(2131364999));
      localbfxb.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361821));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbfxb);
    }
    for (;;)
    {
      localbfxb.jdField_a_of_type_Int = paramInt;
      localbfxb.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbfxb.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbfxb.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbfxb.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbfxb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbfxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbfxb.b.setVisibility(0);
      localbfxb.b.setSingleLine(false);
      localbfxb.b.setMaxLines(2);
      localbfxb.b.setText("");
      localbfxb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbfxb.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = anni.a(2131713986) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843583);
        }
        paramView = this.a.b;
        if (bgsp.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = afur.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!bgsp.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbfxb.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371720)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bgsp.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = anni.a(2131713989) + berw.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbfxb.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361820)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbfxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbfxb.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(atvo.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + anni.a(2131713990);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843585);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843583);
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
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbfxb.b.setText(paramTroopFeedItem.content);
            localbfxb.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbfxb.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843588);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843587);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbfxb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbfxb.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(anni.a(2131713983)))
          {
            localbfxb.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbfxb.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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
 * Qualified Name:     bfxa
 * JD-Core Version:    0.7.0.1
 */