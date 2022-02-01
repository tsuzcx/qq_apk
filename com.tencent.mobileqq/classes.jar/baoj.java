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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class baoj
  extends BaseAdapter
{
  private baoj(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
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
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (i == 0)
      {
        localObject2 = (HistorySignItem)SignatureHistoryFragment.b(this.a).get(paramInt);
        if (paramView == null)
        {
          localObject1 = new BoxShadowLayout(this.a.getActivity());
          paramView = this.a.a((View)localObject1);
          localObject1 = new bapx(this.a.getActivity(), this.a.getActivity().app, (View)localObject1, SignatureHistoryFragment.a(this.a));
          SignatureHistoryFragment.a(this.a).add(localObject1);
          ((bapx)localObject1).a(this.a);
          ((bapx)localObject1).a(this.a);
          Object localObject3 = (LinearLayout)((bapx)localObject1).b();
          ((bapx)localObject1).c().setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((bapx)localObject1).c().setOnClickListener(this.a);
          LayoutInflater.from(this.a.getActivity()).inflate(2131561461, (ViewGroup)localObject3);
          paramView.setTag(localObject1);
          label252:
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364303));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView = ((CommentsView)paramView.findViewById(2131364665));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnSpanItemClick(new baok(this));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemClickListener(new baol(this, (HistorySignItem)localObject2));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemLongClickListener(new baom(this, (HistorySignItem)localObject2));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView = ((LikesView)paramView.findViewById(2131370249));
          ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.setOnItemClickListener(new baoo(this));
          paramView.setTag(localObject1);
          paramView.setClickable(true);
          if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
            break label675;
          }
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setTag(((HistorySignItem)localObject2).richStatus.feedsId);
          label413:
          if (!SignatureHistoryFragment.b(this.a)) {
            break label689;
          }
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
          label447:
          if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
            break label714;
          }
          if (!SignatureHistoryFragment.a(this.a).contains(((HistorySignItem)localObject2).richStatus.feedsId)) {
            break label702;
          }
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          label501:
          ((bapx)localObject1).jdField_a_of_type_Int = paramInt;
          ((bapx)localObject1).c = SignatureHistoryFragment.a(this.a);
          localObject3 = ((HistorySignItem)localObject2).richStatus;
          ((bapx)localObject1).b = ((RichStatus)localObject3);
          ((bapx)localObject1).a((RichStatus)localObject3);
          if (((((HistorySignItem)localObject2).likeItemList == null) || (((HistorySignItem)localObject2).likeItemList.size() <= 0)) && ((((HistorySignItem)localObject2).commentItemList == null) || (((HistorySignItem)localObject2).commentItemList.size() <= 0))) {
            break label726;
          }
          if (((bapx)localObject1).b() != null)
          {
            ((bapx)localObject1).b().setVisibility(0);
            ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.a(((HistorySignItem)localObject2).likeItemList, ((HistorySignItem)localObject2).totalLikeNum);
            ((bapx)localObject1).jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.a(((HistorySignItem)localObject2).commentItemList);
          }
        }
        for (;;)
        {
          ((bapx)localObject1).f = SignatureHistoryFragment.a(this.a, ((HistorySignItem)localObject2).likeItemList, SignatureHistoryFragment.b(this.a));
          ((bapx)localObject1).j();
          break;
          localObject1 = (bapx)paramView.getTag();
          break label252;
          label675:
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setTag("");
          break label413;
          label689:
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          break label447;
          label702:
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label501;
          label714:
          ((bapx)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label501;
          label726:
          if (((bapx)localObject1).b() != null) {
            ((bapx)localObject1).b().setVisibility(8);
          }
        }
      }
      Object localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.a.getActivity().getLayoutInflater().inflate(2131559487, null);
        ((View)localObject1).setBackgroundColor(this.a.getResources().getColor(2131167276));
        paramView = new baop();
        ((View)localObject1).setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131376213));
        ((View)localObject1).findViewById(2131370261).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371401));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165351));
      }
      if (SignatureHistoryFragment.a(this.a) == 1)
      {
        SignatureHistoryFragment.a(this.a, 2);
        this.a.a(false, false);
      }
      paramView = (baop)((View)localObject1).getTag();
      Object localObject2 = new AbsListView.LayoutParams(-1, -2);
      if (SignatureHistoryFragment.a(this.a) == 3)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713227));
        ((AbsListView.LayoutParams)localObject2).height = AIOUtils.dp2px(60.0F, this.a.getResources());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView = (View)localObject1;
      }
      else if (SignatureHistoryFragment.a(this.a) == 2)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713213));
        ((AbsListView.LayoutParams)localObject2).height = AIOUtils.dp2px(60.0F, this.a.getResources());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView = (View)localObject1;
      }
      else
      {
        if (SignatureHistoryFragment.a(this.a) == 0)
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          ((AbsListView.LayoutParams)localObject2).height = (ScreenUtil.SCREEN_HIGHT / 4);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        paramView = (View)localObject1;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoj
 * JD-Core Version:    0.7.0.1
 */