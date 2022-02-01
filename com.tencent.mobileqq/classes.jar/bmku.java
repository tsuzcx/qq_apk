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

public class bmku
  extends RecyclerView.Adapter<bmky>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bmkx jdField_a_of_type_Bmkx;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public bmku(List<AEEditorFilterBean> paramList, int paramInt, bmkx parambmkx)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.g = paramInt;
    this.jdField_a_of_type_Bmkx = parambmkx;
    this.jdField_a_of_type_Boolean = bmby.a();
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
    paramRecyclerView = new bmkw(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  public int a()
  {
    return this.g;
  }
  
  @NonNull
  public bmky a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bmky(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558551, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new FiltersAdapter.1(this, paramInt));
    }
  }
  
  public void a(@NonNull bmky parambmky, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.g)
    {
      i = 1;
      if (i == 0) {
        break label246;
      }
      parambmky.b.setVisibility(0);
      parambmky.b.setBackgroundResource(2130837732);
      parambmky.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
      parambmky.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      parambmky.c.setVisibility(8);
      parambmky.d.setVisibility(8);
      parambmky.e.setVisibility(8);
      parambmky.f.setVisibility(8);
      parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label113:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label535;
      }
      parambmky.jdField_a_of_type_AndroidWidgetTextView.setText(2131692303);
      if (i != 0) {
        parambmky.b.setImageResource(2130837724);
      }
      parambmky.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837725);
      parambmky.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837754);
      parambmky.c.setVisibility(8);
      parambmky.d.setVisibility(8);
      parambmky.e.setVisibility(8);
      parambmky.f.setVisibility(8);
      parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    for (;;)
    {
      parambmky.itemView.setOnClickListener(new bmkv(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(parambmky, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label246:
      parambmky.b.setVisibility(8);
      parambmky.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
      parambmky.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.d);
      String str = bmkn.a().b(localAEEditorFilterBean);
      if ((localAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK))
      {
        parambmky.c.setVisibility(8);
        parambmky.d.setVisibility(8);
        parambmky.e.setVisibility(8);
        parambmky.f.setVisibility(8);
        parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label113;
      }
      if (((!TextUtils.isEmpty(str)) && (new File(str).exists())) || (localAEEditorFilterBean.getProgress() == 100))
      {
        parambmky.c.setVisibility(8);
        parambmky.d.setVisibility(8);
        parambmky.e.setVisibility(8);
        parambmky.f.setVisibility(8);
        parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label113;
      }
      if (localAEEditorFilterBean.getProgress() >= 0)
      {
        parambmky.c.setVisibility(8);
        parambmky.d.setVisibility(8);
        parambmky.e.setVisibility(0);
        parambmky.f.setVisibility(0);
        parambmky.a(localAEEditorFilterBean);
        break label113;
      }
      parambmky.c.setVisibility(0);
      parambmky.d.setVisibility(0);
      parambmky.e.setVisibility(8);
      parambmky.f.setVisibility(8);
      parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      break label113;
      label535:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.AIFilter) {
        break label628;
      }
      parambmky.jdField_a_of_type_AndroidWidgetTextView.setText(2131692301);
      if (i != 0) {
        parambmky.b.setImageResource(2130837718);
      }
      parambmky.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837721);
      parambmky.c.setVisibility(8);
      parambmky.d.setVisibility(8);
      parambmky.e.setVisibility(8);
      parambmky.f.setVisibility(8);
      parambmky.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    label628:
    parambmky.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
    if (i != 0)
    {
      if (localAEEditorFilterBean.getEditorEffectItem().getHideAlphaBar() == 1) {
        break label718;
      }
      parambmky.b.setImageResource(2130837731);
    }
    for (;;)
    {
      parambmky.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837754);
      UIUtils.setViewByURL(parambmky.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), UIUtils.dip2px(parambmky.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.dip2px(parambmky.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break;
      label718:
      parambmky.b.setImageResource(2130837718);
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
    this.jdField_a_of_type_Int = paramRecyclerView.getResources().getColor(2131165268);
    this.b = paramRecyclerView.getResources().getColor(2131165273);
    this.c = paramRecyclerView.getResources().getColor(2131165274);
    this.d = paramRecyclerView.getResources().getColor(2131165270);
    this.e = paramRecyclerView.getResources().getColor(2131165271);
    this.f = paramRecyclerView.getResources().getColor(2131165272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmku
 * JD-Core Version:    0.7.0.1
 */