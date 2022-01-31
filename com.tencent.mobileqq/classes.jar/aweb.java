import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class aweb
  extends BaseAdapter
{
  private aweb(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public int getCount()
  {
    int i = SignatureHistoryFragment.b(this.a).size();
    if (i == 0) {
      return 1;
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= SignatureHistoryFragment.b(this.a).size()) {
      return null;
    }
    return SignatureHistoryFragment.b(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = SignatureHistoryFragment.b(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      SignatureHistoryFragment.a(this.a).setLayoutParams(new AbsListView.LayoutParams(this.a.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.a.jdField_a_of_type_ComTencentWidgetXListView.getHeight()));
      paramView = SignatureHistoryFragment.a(this.a);
    }
    Object localObject1;
    Object localObject2;
    label379:
    label639:
    do
    {
      return paramView;
      if (i == 0)
      {
        localObject1 = (HistorySignItem)SignatureHistoryFragment.b(this.a).get(paramInt);
        if (paramView == null)
        {
          paramViewGroup = new BoxShadowLayout(this.a.getActivity());
          paramView = this.a.a(paramViewGroup);
          paramViewGroup = new awfp(this.a.getActivity(), this.a.getActivity().app, paramViewGroup, SignatureHistoryFragment.a(this.a));
          SignatureHistoryFragment.a(this.a).add(paramViewGroup);
          paramViewGroup.a(this.a);
          paramViewGroup.a(this.a);
          localObject2 = (LinearLayout)paramViewGroup.b();
          paramViewGroup.c().setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
          paramViewGroup.c().setOnClickListener(this.a);
          LayoutInflater.from(this.a.getActivity()).inflate(2131561107, (ViewGroup)localObject2);
          paramView.setTag(paramViewGroup);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363979));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView = ((CommentsView)paramView.findViewById(2131364308));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnSpanItemClick(new awec(this));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemClickListener(new awed(this, (HistorySignItem)localObject1));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemLongClickListener(new awee(this, (HistorySignItem)localObject1));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView = ((LikesView)paramView.findViewById(2131369470));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.setOnItemClickListener(new aweg(this));
          paramView.setTag(paramViewGroup);
          paramView.setClickable(true);
          if ((localObject1 == null) || (((HistorySignItem)localObject1).richStatus == null) || (((HistorySignItem)localObject1).richStatus.feedsId == null)) {
            break label626;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag(((HistorySignItem)localObject1).richStatus.feedsId);
          if (!SignatureHistoryFragment.b(this.a)) {
            break label639;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((localObject1 == null) || (((HistorySignItem)localObject1).richStatus == null) || (((HistorySignItem)localObject1).richStatus.feedsId == null)) {
            break label662;
          }
          if (!SignatureHistoryFragment.a(this.a).contains(((HistorySignItem)localObject1).richStatus.feedsId)) {
            break label651;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          paramViewGroup.jdField_a_of_type_Int = paramInt;
          paramViewGroup.c = SignatureHistoryFragment.a(this.a);
          localObject2 = ((HistorySignItem)localObject1).richStatus;
          paramViewGroup.b = ((RichStatus)localObject2);
          paramViewGroup.a((RichStatus)localObject2);
          if (((((HistorySignItem)localObject1).likeItemList == null) || (((HistorySignItem)localObject1).likeItemList.size() <= 0)) && ((((HistorySignItem)localObject1).commentItemList == null) || (((HistorySignItem)localObject1).commentItemList.size() <= 0))) {
            break label673;
          }
          if (paramViewGroup.b() != null)
          {
            paramViewGroup.b().setVisibility(0);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.a(((HistorySignItem)localObject1).likeItemList, ((HistorySignItem)localObject1).totalLikeNum);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.a(((HistorySignItem)localObject1).commentItemList);
          }
        }
        for (;;)
        {
          paramViewGroup.f = SignatureHistoryFragment.a(this.a, ((HistorySignItem)localObject1).likeItemList, SignatureHistoryFragment.b(this.a));
          paramViewGroup.j();
          return paramView;
          paramViewGroup = (awfp)paramView.getTag();
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag("");
          break label379;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          break label411;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label464;
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label464;
          if (paramViewGroup.b() != null) {
            paramViewGroup.b().setVisibility(8);
          }
        }
      }
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131559314, null);
        paramViewGroup.setBackgroundColor(this.a.getResources().getColor(2131167087));
        paramView = new aweh();
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131375056));
        paramViewGroup.findViewById(2131369480).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370442));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165275));
      }
      if (SignatureHistoryFragment.a(this.a) == 1)
      {
        SignatureHistoryFragment.a(this.a, 2);
        this.a.a(false, false);
      }
      localObject1 = (aweh)paramViewGroup.getTag();
      localObject2 = new AbsListView.LayoutParams(-1, -2);
      if (SignatureHistoryFragment.a(this.a) == 3)
      {
        ((aweh)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((aweh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131714132));
        ((AbsListView.LayoutParams)localObject2).height = actj.a(60.0F, this.a.getResources());
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        return paramViewGroup;
      }
      if (SignatureHistoryFragment.a(this.a) == 2)
      {
        ((aweh)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((aweh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131714118));
        ((AbsListView.LayoutParams)localObject2).height = actj.a(60.0F, this.a.getResources());
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (SignatureHistoryFragment.a(this.a) != 0);
    label411:
    label464:
    label626:
    ((aweh)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    label651:
    label662:
    label673:
    ((aweh)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((AbsListView.LayoutParams)localObject2).height = (axlk.b / 4);
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aweb
 * JD-Core Version:    0.7.0.1
 */