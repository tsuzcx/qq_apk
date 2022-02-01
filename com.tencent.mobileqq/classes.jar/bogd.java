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

public class bogd
  extends RecyclerView.Adapter<bogh>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bogg jdField_a_of_type_Bogg;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public bogd(List<AEEditorFilterBean> paramList, int paramInt, bogg parambogg)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.g = paramInt;
    this.jdField_a_of_type_Bogg = parambogg;
    this.jdField_a_of_type_Boolean = bnzc.a();
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
    paramRecyclerView = new bogf(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  public int a()
  {
    return this.g;
  }
  
  @NonNull
  public bogh a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bogh(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558550, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new FiltersAdapter.1(this, paramInt));
    }
  }
  
  public void a(@NonNull bogh parambogh, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.g)
    {
      i = 1;
      if (i == 0) {
        break label248;
      }
      parambogh.b.setVisibility(0);
      parambogh.b.setBackgroundColor(this.jdField_a_of_type_Int);
      parambogh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
      parambogh.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      parambogh.c.setVisibility(8);
      parambogh.d.setVisibility(8);
      parambogh.e.setVisibility(8);
      parambogh.f.setVisibility(8);
      parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label115:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label537;
      }
      parambogh.jdField_a_of_type_AndroidWidgetTextView.setText(2131692250);
      if (i != 0) {
        parambogh.b.setImageResource(2130837708);
      }
      parambogh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837709);
      parambogh.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837734);
      parambogh.c.setVisibility(8);
      parambogh.d.setVisibility(8);
      parambogh.e.setVisibility(8);
      parambogh.f.setVisibility(8);
      parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    for (;;)
    {
      parambogh.itemView.setOnClickListener(new boge(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(parambogh, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label248:
      parambogh.b.setVisibility(8);
      parambogh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
      parambogh.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.d);
      String str = bofw.a().b(localAEEditorFilterBean);
      if ((localAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK))
      {
        parambogh.c.setVisibility(8);
        parambogh.d.setVisibility(8);
        parambogh.e.setVisibility(8);
        parambogh.f.setVisibility(8);
        parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label115;
      }
      if (((!TextUtils.isEmpty(str)) && (new File(str).exists())) || (localAEEditorFilterBean.getProgress() == 100))
      {
        parambogh.c.setVisibility(8);
        parambogh.d.setVisibility(8);
        parambogh.e.setVisibility(8);
        parambogh.f.setVisibility(8);
        parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label115;
      }
      if (localAEEditorFilterBean.getProgress() >= 0)
      {
        parambogh.c.setVisibility(8);
        parambogh.d.setVisibility(8);
        parambogh.e.setVisibility(0);
        parambogh.f.setVisibility(0);
        parambogh.a(localAEEditorFilterBean);
        break label115;
      }
      parambogh.c.setVisibility(0);
      parambogh.d.setVisibility(0);
      parambogh.e.setVisibility(8);
      parambogh.f.setVisibility(8);
      parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      break label115;
      label537:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.AIFilter) {
        break label630;
      }
      parambogh.jdField_a_of_type_AndroidWidgetTextView.setText(2131692248);
      if (i != 0) {
        parambogh.b.setImageResource(2130837702);
      }
      parambogh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837705);
      parambogh.c.setVisibility(8);
      parambogh.d.setVisibility(8);
      parambogh.e.setVisibility(8);
      parambogh.f.setVisibility(8);
      parambogh.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
    }
    label630:
    parambogh.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
    if (i != 0)
    {
      if (localAEEditorFilterBean.getEditorEffectItem().getHideAlphaBar() == 1) {
        break label720;
      }
      parambogh.b.setImageResource(2130837715);
    }
    for (;;)
    {
      parambogh.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837734);
      zlx.a(parambogh.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), zlx.a(parambogh.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), zlx.a(parambogh.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break;
      label720:
      parambogh.b.setImageResource(2130837702);
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
 * Qualified Name:     bogd
 * JD-Core Version:    0.7.0.1
 */