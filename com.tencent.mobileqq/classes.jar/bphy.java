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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;
import dov.com.qq.im.aeeditor.module.filter.FiltersAdapter.1;
import java.io.File;
import java.util.List;

public class bphy
  extends RecyclerView.Adapter<bpic>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bpib jdField_a_of_type_Bpib;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public bphy(List<AEEditorFilterBean> paramList, int paramInt, bpib parambpib)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.g = paramInt;
    this.jdField_a_of_type_Bpib = parambpib;
    this.jdField_a_of_type_Boolean = bpan.a();
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
    paramRecyclerView = new bpia(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  public int a()
  {
    return this.g;
  }
  
  @NonNull
  public bpic a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bpic(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558552, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new FiltersAdapter.1(this, paramInt));
    }
  }
  
  public void a(@NonNull bpic parambpic, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.g)
    {
      i = 1;
      if (i == 0) {
        break label248;
      }
      parambpic.b.setVisibility(0);
      parambpic.b.setBackgroundColor(this.jdField_a_of_type_Int);
      parambpic.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
      parambpic.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      parambpic.c.setVisibility(8);
      parambpic.d.setVisibility(8);
      parambpic.e.setVisibility(8);
      parambpic.f.setVisibility(8);
      parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label115:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label537;
      }
      parambpic.jdField_a_of_type_AndroidWidgetTextView.setText(2131692255);
      if (i != 0) {
        parambpic.b.setImageResource(2130837714);
      }
      parambpic.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837715);
      parambpic.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837741);
      parambpic.c.setVisibility(8);
      parambpic.d.setVisibility(8);
      parambpic.e.setVisibility(8);
      parambpic.f.setVisibility(8);
      parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    for (;;)
    {
      parambpic.itemView.setOnClickListener(new bphz(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(parambpic, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label248:
      parambpic.b.setVisibility(8);
      parambpic.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
      parambpic.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.d);
      String str = bphr.a().b(localAEEditorFilterBean);
      if ((localAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK))
      {
        parambpic.c.setVisibility(8);
        parambpic.d.setVisibility(8);
        parambpic.e.setVisibility(8);
        parambpic.f.setVisibility(8);
        parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label115;
      }
      if (((!TextUtils.isEmpty(str)) && (new File(str).exists())) || (localAEEditorFilterBean.getProgress() == 100))
      {
        parambpic.c.setVisibility(8);
        parambpic.d.setVisibility(8);
        parambpic.e.setVisibility(8);
        parambpic.f.setVisibility(8);
        parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label115;
      }
      if (localAEEditorFilterBean.getProgress() >= 0)
      {
        parambpic.c.setVisibility(8);
        parambpic.d.setVisibility(8);
        parambpic.e.setVisibility(0);
        parambpic.f.setVisibility(0);
        parambpic.a(localAEEditorFilterBean);
        break label115;
      }
      parambpic.c.setVisibility(0);
      parambpic.d.setVisibility(0);
      parambpic.e.setVisibility(8);
      parambpic.f.setVisibility(8);
      parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      break label115;
      label537:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.AIFilter) {
        break label630;
      }
      parambpic.jdField_a_of_type_AndroidWidgetTextView.setText(2131692253);
      if (i != 0) {
        parambpic.b.setImageResource(2130837708);
      }
      parambpic.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837711);
      parambpic.c.setVisibility(8);
      parambpic.d.setVisibility(8);
      parambpic.e.setVisibility(8);
      parambpic.f.setVisibility(8);
      parambpic.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    label630:
    parambpic.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
    if (i != 0)
    {
      if (localAEEditorFilterBean.getEditorEffectItem().getHideAlphaBar() == 1) {
        break label720;
      }
      parambpic.b.setImageResource(2130837721);
    }
    for (;;)
    {
      parambpic.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837741);
      zps.a(parambpic.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), zps.a(parambpic.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), zps.a(parambpic.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break;
      label720:
      parambpic.b.setImageResource(2130837708);
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
    this.jdField_a_of_type_Int = paramRecyclerView.getResources().getColor(2131165262);
    this.b = paramRecyclerView.getResources().getColor(2131165267);
    this.c = paramRecyclerView.getResources().getColor(2131165268);
    this.d = paramRecyclerView.getResources().getColor(2131165264);
    this.e = paramRecyclerView.getResources().getColor(2131165265);
    this.f = paramRecyclerView.getResources().getColor(2131165266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphy
 * JD-Core Version:    0.7.0.1
 */