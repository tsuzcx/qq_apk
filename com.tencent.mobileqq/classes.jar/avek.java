import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avek
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private avha jdField_a_of_type_Avha;
  private Comments jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private final String jdField_a_of_type_JavaLangString = "CommentsAdapter";
  public boolean a;
  private int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public avek(Context paramContext, Comments paramComments, VideoData paramVideoData, avha paramavha, Paint paramPaint, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = paramComments;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_Avha = paramavha;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    this.c = paramInt;
  }
  
  public Comments.Comment a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size())) {
      return (Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt);
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentsAdapter", 2, "getview position is: " + paramInt);
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0)) {
      if ((paramView == null) || (!(paramView.getTag() instanceof aveo)))
      {
        paramView = new aveo();
        localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561078, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368751));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378896));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378722));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378934));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367734));
        paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131365999));
        paramView.d = ((ImageView)((View)localObject).findViewById(2131378157));
        ((View)localObject).setTag(2131364556, paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_JavaLangString);
        if ((((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).e <= 0L) && (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).f <= 0L)) {
          break label666;
        }
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_JavaLangString, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
        label318:
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Long);
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        String str1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString;
        String str2 = String.valueOf(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long);
        if (((str1 != null) && (!str1.isEmpty())) || (!str2.equals(((QQAppInterface)localObject).getCurrentAccountUin()))) {
          break label692;
        }
        localObject = bdbk.a((AppInterface)localObject, 32, str2, 3, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845022), paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845022));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        label469:
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo, this.c, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_Boolean);
        long l1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long;
        long l2 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_Long;
        long l3 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Int;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new avel(this, l1, l2, l3));
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_Int == 2) {
          paramViewGroup.d.setVisibility(0);
        }
        paramView.setTag(2131364547, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt));
        paramView.setTag(2131364599, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments);
        localObject = paramView;
      }
    }
    label666:
    label692:
    do
    {
      return localObject;
      paramViewGroup = (aveo)paramView.getTag();
      break;
      paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
      break label318;
      avef.a().a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845022), paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845022), null, true);
      break label469;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
      {
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
        return paramView;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("badnet".equals((String)paramView.getTag()))) {}
        for (;;)
        {
          paramView.setBackgroundColor(Color.parseColor("#ffffff"));
          paramView.findViewById(2131369706).setOnClickListener(new avem(this));
          paramView.setTag("badnet");
          return paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561068, paramViewGroup, false);
        }
      }
      if ((paramView == null) || (!(paramView.getTag() instanceof String))) {
        break label910;
      }
      localObject = paramView;
    } while ("empty".equals((String)paramView.getTag()));
    label910:
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561069, paramViewGroup, false);
    paramView.setTag("empty");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avek
 * JD-Core Version:    0.7.0.1
 */