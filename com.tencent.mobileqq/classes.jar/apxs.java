import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public abstract class apxs
  extends apxp
{
  protected Context a;
  protected FrameLayout a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  protected TextView c;
  
  public apxs(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312487));
    this.b = ((TextView)paramView.findViewById(2131312407));
    this.c = ((TextView)paramView.findViewById(2131312218));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302305));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131303271));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131303241));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    this.itemView.setBackgroundDrawable(apyr.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
    if (!TextUtils.isEmpty(paramFeedsItemData.rcmdReason))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramFeedsItemData.rcmdReason + "");
      if ((!TextUtils.isEmpty(paramFeedsItemData.label)) || (!TextUtils.isEmpty(paramFeedsItemData.operateText))) {
        break label130;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.itemView.setOnClickListener(new apxt(this, paramFeedsItemData));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label130:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (TextUtils.isEmpty(paramFeedsItemData.operateText))
      {
        this.c.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramFeedsItemData.label)) {
          break label287;
        }
        this.b.setVisibility(8);
        break;
        this.c.setText(paramFeedsItemData.operateText + "");
        this.c.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.itemView.getResources().getDrawable(2130840586);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.itemView.getResources().getDrawable(2130840586);
        localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201908/upload_edff4f642a92ef91b6cb1b7209369506.png", (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label287:
      this.b.setText(paramFeedsItemData.label + "");
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apxs
 * JD-Core Version:    0.7.0.1
 */