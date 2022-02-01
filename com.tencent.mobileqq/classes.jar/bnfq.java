import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.camera.ui.panel.AEGridView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.1;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.4;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnfq
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, bczs, bnkq
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private bnfv jdField_a_of_type_Bnfv;
  private bnkb jdField_a_of_type_Bnkb;
  public bnke a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public String a;
  public ArrayList<bnke> a;
  private boolean jdField_a_of_type_Boolean;
  
  public bnfq(Context paramContext, AEGridView paramAEGridView, bnfv parambnfv, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a(18));
    this.jdField_a_of_type_Bnfv = parambnfv;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(bnke parambnke)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(parambnke.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(bnke parambnke, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambnke == null) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    label423:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = parambnke.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_JavaLangString);
      bnqq.a().c(-1);
      bnqq.a().g("none");
      bnqq.a().f("1");
      bnqq.a().d(0);
      Object localObject;
      if (parambnke != null)
      {
        bnqm.a().d(parambnke.jdField_a_of_type_JavaLangString);
        bnrh.b("AEMaterialAdapter", "【Select Material】：" + parambnke.jdField_a_of_type_JavaLangString);
        bnrh.b("AEMaterialAdapter", "【Select Material】Usable :" + parambnke.e);
        if ((parambnke != null) && (!TextUtils.isEmpty(parambnke.jdField_a_of_type_JavaLangString)) && (!bnke.a(parambnke))) {
          break label240;
        }
        if (this.jdField_a_of_type_Bnfv != null) {
          this.jdField_a_of_type_Bnfv.a();
        }
        parambnke = this.jdField_a_of_type_Bnkb;
        localObject = bnke.jdField_a_of_type_Bnke;
        if (this.jdField_a_of_type_Boolean) {
          break label235;
        }
      }
      for (;;)
      {
        parambnke.a((bnke)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bnqm.a().d("null");
        bnrh.b("AEMaterialAdapter", "【Select Material】：null");
        break;
        label235:
        bool1 = false;
      }
      label240:
      if (parambnke.a())
      {
        zfn.a(this.jdField_a_of_type_AndroidContentContext, parambnke);
        return;
      }
      if (parambnke.e)
      {
        if (!bnky.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131709277), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        localObject = this.jdField_a_of_type_Bnkb;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((bnkb)localObject).a(parambnke, bool1);
          if (this.jdField_a_of_type_Bnfv != null) {
            this.jdField_a_of_type_Bnfv.a(parambnke);
          }
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + parambnke.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label423;
        }
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (!bnlb.j(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))) {
          break label425;
        }
        this.jdField_a_of_type_Bnkb.b(parambnke);
        return;
        bool1 = false;
        break;
        c(parambnke);
      }
    }
    label425:
    this.jdField_a_of_type_Bnkb.a(parambnke);
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(bnke parambnke)
  {
    if ((this.jdField_a_of_type_Bnke != null) && (!this.jdField_a_of_type_Bnke.equals(parambnke)))
    {
      this.jdField_a_of_type_Bnke.b = false;
      this.jdField_a_of_type_Bnke.c = false;
    }
    this.jdField_a_of_type_Bnke = parambnke;
  }
  
  private void c(bnke parambnke)
  {
    if (parambnke == null) {}
    while ((parambnke.f) || (TextUtils.isEmpty(parambnke.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bnkb == null)) {
      return;
    }
    d(parambnke);
  }
  
  private void d(bnke parambnke)
  {
    this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnkb.getApp(), parambnke, this);
  }
  
  public void a(bnke parambnke)
  {
    a(parambnke, a(parambnke));
  }
  
  public void a(List<bnke> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(bnke.jdField_a_of_type_Bnke);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 113) {
      if (bnkb.a() != null) {
        notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt == 1024)
          {
            QLog.d("AEMaterialAdapter", 4, "current watermark has change");
            notifyDataSetChanged();
            return;
          }
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.jdField_a_of_type_Boolean));
        a(((bnka)paramVarArgs[0]).a);
        notifyDataSetChanged();
        return;
        if (paramInt != 114) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
      a(true, paramVarArgs[0]);
      return;
    } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
    a(false, paramVarArgs[0]);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bnke localbnke = (bnke)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localbnke == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      if ((paramViewHolder instanceof bngn))
      {
        localObject = (bngn)paramViewHolder;
        if ((bnkb.a() == null) || (localbnke.equals(bnkb.a()))) {
          ((bngn)localObject).a();
        } else {
          ((bngn)localObject).b();
        }
      }
      else if ((paramViewHolder instanceof bngo))
      {
        localObject = (bngo)paramViewHolder;
        if ((localbnke.equals(bnkb.a())) && (localbnke.e))
        {
          ((bngo)localObject).a(2, localbnke);
        }
        else
        {
          localbnke.jdField_a_of_type_Boolean = false;
          ((bngo)localObject).a(1, localbnke);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bnke localbnke = (bnke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    b(localbnke);
    if (localbnke.b) {
      localbnke.c = true;
    }
    for (;;)
    {
      a(localbnke, i);
      break;
      localbnke.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558513, paramViewGroup, false);
      paramViewGroup = new bngn(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558512, paramViewGroup, false);
      paramViewGroup = new bngo(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    if (parambnke == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(parambnke);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, parambnke, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    paramInt = a(parambnke);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfq
 * JD-Core Version:    0.7.0.1
 */