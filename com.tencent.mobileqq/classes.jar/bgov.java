import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class bgov
  extends bgoy
{
  bgov(bgos parambgos)
  {
    super(parambgos);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560634, null);
    }
    bgow localbgow = (bgow)localView3.getTag();
    if (localbgow == null)
    {
      localbgow = new bgow(this);
      localbgow.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131372790));
      localbgow.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131379001));
      localbgow.b = ((TextView)localView3.findViewById(2131365157));
      localbgow.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361823));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localbgow);
    }
    for (;;)
    {
      localbgow.jdField_a_of_type_Int = paramInt;
      localbgow.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localbgow.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localbgow.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localbgow.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localbgow.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localbgow.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localbgow.b.setVisibility(0);
      localbgow.b.setSingleLine(false);
      localbgow.b.setMaxLines(2);
      localbgow.b.setText("");
      localbgow.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localbgow.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = anvx.a(2131714674) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843701);
        }
        paramView = this.a.b;
        if (StringUtil.isEmpty(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = AIOUtils.dp2px(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!StringUtil.isEmpty(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localbgow.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371981)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!StringUtil.isEmpty(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = anvx.a(2131714677) + bfhq.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localbgow.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361822)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localbgow.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localbgow.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageResource(auea.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + anvx.a(2131714678);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843703);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843701);
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
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localbgow.b.setText(paramTroopFeedItem.content);
            localbgow.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbgow.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843706);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843705);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localbgow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localbgow.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(anvx.a(2131714671)))
          {
            localbgow.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localbgow.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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
 * Qualified Name:     bgov
 * JD-Core Version:    0.7.0.1
 */