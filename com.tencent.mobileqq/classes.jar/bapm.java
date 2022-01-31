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

class bapm
  extends bapp
{
  bapm(bapj parambapj)
  {
    super(parambapj);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560295, null);
    }
    bapn localbapn = (bapn)localView3.getTag();
    if (localbapn == null)
    {
      localbapn = new bapn(this);
      localbapn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131371608));
      localbapn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131377350));
      localbapn.b = ((TextView)localView3.findViewById(2131364691));
      localbapn.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361820));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbapn);
    }
    for (;;)
    {
      localbapn.jdField_a_of_type_Int = paramInt;
      localbapn.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbapn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbapn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbapn.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbapn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbapn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbapn.b.setVisibility(0);
      localbapn.b.setSingleLine(false);
      localbapn.b.setMaxLines(2);
      localbapn.b.setText("");
      localbapn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbapn.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = ajya.a(2131715321) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843025);
        }
        paramView = this.a.b;
        if (bbkk.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = actj.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!bbkk.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbapn.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370832)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!bbkk.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = ajya.a(2131715324) + azot.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbapn.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361819)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbapn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbapn.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(apug.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + ajya.a(2131715325);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843027);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843025);
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
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbapn.b.setText(paramTroopFeedItem.content);
            localbapn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbapn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843030);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843029);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbapn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbapn.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(ajya.a(2131715318)))
          {
            localbapn.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbapn.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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
 * Qualified Name:     bapm
 * JD-Core Version:    0.7.0.1
 */