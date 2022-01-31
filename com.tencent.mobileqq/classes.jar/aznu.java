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

class aznu
  extends aznx
{
  aznu(aznr paramaznr)
  {
    super(paramaznr);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131494723, null);
    }
    aznv localaznv = (aznv)localView3.getTag();
    if (localaznv == null)
    {
      localaznv = new aznv(this);
      localaznv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131305912));
      localaznv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131311534));
      localaznv.b = ((TextView)localView3.findViewById(2131299132));
      localaznv.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131296285));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localaznv);
    }
    for (;;)
    {
      localaznv.jdField_a_of_type_Int = paramInt;
      localaznv.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localaznv.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localaznv.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localaznv.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localaznv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localaznv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localaznv.b.setVisibility(0);
      localaznv.b.setSingleLine(false);
      localaznv.b.setMaxLines(2);
      localaznv.b.setText("");
      localaznv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localaznv.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = ajjy.a(2131649520) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842941);
        }
        paramView = this.a.b;
        if (baip.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = aciy.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
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
            if (!baip.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localaznv.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305159)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!baip.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = ajjy.a(2131649523) + ayob.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localaznv.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296284)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localaznv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localaznv.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(apck.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + ajjy.a(2131649524);
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
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842943);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842941);
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
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localaznv.b.setText(paramTroopFeedItem.content);
            localaznv.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localaznv.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842946);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842945);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localaznv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localaznv.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(ajjy.a(2131649517)))
          {
            localaznv.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localaznv.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
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
 * Qualified Name:     aznu
 * JD-Core Version:    0.7.0.1
 */