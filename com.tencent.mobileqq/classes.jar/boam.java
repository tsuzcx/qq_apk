import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;
import dov.com.qq.im.aeeditor.module.filter.FiltersAdapter.1;
import java.io.File;
import java.util.List;

public class boam
  extends RecyclerView.Adapter<boaq>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private boap jdField_a_of_type_Boap;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public boam(List<AEEditorFilterBean> paramList, int paramInt, boap paramboap)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.g = paramInt;
    this.jdField_a_of_type_Boap = paramboap;
    this.jdField_a_of_type_Boolean = bnri.a();
  }
  
  public static void a(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {}
    LinearLayoutManager localLinearLayoutManager;
    do
    {
      return;
      localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    } while (localLinearLayoutManager == null);
    paramRecyclerView = new boao(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  public int a()
  {
    return this.g;
  }
  
  @NonNull
  public boaq a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new boaq(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558562, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new FiltersAdapter.1(this, paramInt));
    }
  }
  
  public void a(@NonNull boaq paramboaq, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.g)
    {
      i = 1;
      if (i == 0) {
        break label246;
      }
      paramboaq.b.setVisibility(0);
      paramboaq.b.setBackgroundResource(2130837746);
      paramboaq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
      paramboaq.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramboaq.c.setVisibility(8);
      paramboaq.d.setVisibility(8);
      paramboaq.e.setVisibility(8);
      paramboaq.f.setVisibility(8);
      paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label113:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label535;
      }
      paramboaq.jdField_a_of_type_AndroidWidgetTextView.setText(2131692396);
      if (i != 0) {
        paramboaq.b.setImageResource(2130837738);
      }
      paramboaq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837739);
      paramboaq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837908);
      paramboaq.c.setVisibility(8);
      paramboaq.d.setVisibility(8);
      paramboaq.e.setVisibility(8);
      paramboaq.f.setVisibility(8);
      paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    for (;;)
    {
      paramboaq.itemView.setOnClickListener(new boan(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramboaq, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label246:
      paramboaq.b.setVisibility(8);
      paramboaq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
      paramboaq.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.d);
      String str = boaf.a().b(localAEEditorFilterBean);
      if ((localAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK))
      {
        paramboaq.c.setVisibility(8);
        paramboaq.d.setVisibility(8);
        paramboaq.e.setVisibility(8);
        paramboaq.f.setVisibility(8);
        paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label113;
      }
      if (((!TextUtils.isEmpty(str)) && (new File(str).exists())) || (localAEEditorFilterBean.getProgress() == 100))
      {
        paramboaq.c.setVisibility(8);
        paramboaq.d.setVisibility(8);
        paramboaq.e.setVisibility(8);
        paramboaq.f.setVisibility(8);
        paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label113;
      }
      if (localAEEditorFilterBean.getProgress() >= 0)
      {
        paramboaq.c.setVisibility(8);
        paramboaq.d.setVisibility(8);
        paramboaq.e.setVisibility(0);
        paramboaq.f.setVisibility(0);
        paramboaq.a(localAEEditorFilterBean);
        break label113;
      }
      paramboaq.c.setVisibility(0);
      paramboaq.d.setVisibility(0);
      paramboaq.e.setVisibility(8);
      paramboaq.f.setVisibility(8);
      paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      break label113;
      label535:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.AIFilter) {
        break label628;
      }
      paramboaq.jdField_a_of_type_AndroidWidgetTextView.setText(2131692391);
      if (i != 0) {
        paramboaq.b.setImageResource(2130837732);
      }
      paramboaq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837735);
      paramboaq.c.setVisibility(8);
      paramboaq.d.setVisibility(8);
      paramboaq.e.setVisibility(8);
      paramboaq.f.setVisibility(8);
      paramboaq.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    label628:
    paramboaq.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
    if (i != 0)
    {
      if (localAEEditorFilterBean.getEditorEffectItem().getHideAlphaBar() == 1) {
        break label718;
      }
      paramboaq.b.setImageResource(2130837745);
    }
    for (;;)
    {
      paramboaq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837908);
      UIUtils.setViewByURL(paramboaq.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), UIUtils.dip2px(paramboaq.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.dip2px(paramboaq.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break;
      label718:
      paramboaq.b.setImageResource(2130837732);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Int = paramRecyclerView.getResources().getColor(2131165271);
    this.b = paramRecyclerView.getResources().getColor(2131165276);
    this.c = paramRecyclerView.getResources().getColor(2131165277);
    this.d = paramRecyclerView.getResources().getColor(2131165273);
    this.e = paramRecyclerView.getResources().getColor(2131165274);
    this.f = paramRecyclerView.getResources().getColor(2131165275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boam
 * JD-Core Version:    0.7.0.1
 */