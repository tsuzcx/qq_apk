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
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class blsh
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, bbsx, blvj
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private blsm jdField_a_of_type_Blsm;
  private bluy jdField_a_of_type_Bluy;
  public blvb a;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  public String a;
  public ArrayList<blvb> a;
  private boolean jdField_a_of_type_Boolean;
  
  public blsh(Context paramContext, AEGridView paramAEGridView, blsm paramblsm, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Bluy = ((bluy)bmql.a(18));
    this.jdField_a_of_type_Blsm = paramblsm;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(blvb paramblvb)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((blvb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramblvb.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(blvb paramblvb, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramblvb == null) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    label423:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramblvb.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_JavaLangString);
      bmbg.a().c(-1);
      bmbg.a().g("none");
      bmbg.a().f("1");
      bmbg.a().d(0);
      Object localObject;
      if (paramblvb != null)
      {
        bmbc.a().d(paramblvb.jdField_a_of_type_JavaLangString);
        bmbx.b("AEMaterialAdapter", "【Select Material】：" + paramblvb.jdField_a_of_type_JavaLangString);
        bmbx.b("AEMaterialAdapter", "【Select Material】Usable :" + paramblvb.e);
        if ((paramblvb != null) && (!TextUtils.isEmpty(paramblvb.jdField_a_of_type_JavaLangString)) && (!blvb.a(paramblvb))) {
          break label240;
        }
        if (this.jdField_a_of_type_Blsm != null) {
          this.jdField_a_of_type_Blsm.a();
        }
        paramblvb = this.jdField_a_of_type_Bluy;
        localObject = blvb.jdField_a_of_type_Blvb;
        if (this.jdField_a_of_type_Boolean) {
          break label235;
        }
      }
      for (;;)
      {
        paramblvb.a((blvb)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        bmbc.a().d("null");
        bmbx.b("AEMaterialAdapter", "【Select Material】：null");
        break;
        label235:
        bool1 = false;
      }
      label240:
      if (paramblvb.a())
      {
        yqu.a(this.jdField_a_of_type_AndroidContentContext, paramblvb);
        return;
      }
      if (paramblvb.e)
      {
        if (!AEResUtil.isAEBaseSoReady())
        {
          QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131708930), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        localObject = this.jdField_a_of_type_Bluy;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((bluy)localObject).a(paramblvb, bool1);
          if (this.jdField_a_of_type_Blsm != null) {
            this.jdField_a_of_type_Blsm.a(paramblvb);
          }
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + paramblvb.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label423;
        }
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (!blvr.j(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))) {
          break label425;
        }
        this.jdField_a_of_type_Bluy.b(paramblvb);
        return;
        bool1 = false;
        break;
        c(paramblvb);
      }
    }
    label425:
    this.jdField_a_of_type_Bluy.a(paramblvb);
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
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((blvb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((blvb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void b(blvb paramblvb)
  {
    if ((this.jdField_a_of_type_Blvb != null) && (!this.jdField_a_of_type_Blvb.equals(paramblvb)))
    {
      this.jdField_a_of_type_Blvb.b = false;
      this.jdField_a_of_type_Blvb.c = false;
    }
    this.jdField_a_of_type_Blvb = paramblvb;
  }
  
  private void c(blvb paramblvb)
  {
    if (paramblvb == null) {}
    while ((paramblvb.f) || (TextUtils.isEmpty(paramblvb.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bluy == null)) {
      return;
    }
    d(paramblvb);
  }
  
  private void d(blvb paramblvb)
  {
    this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Bluy.getApp(), paramblvb, this);
  }
  
  public void a(blvb paramblvb)
  {
    a(paramblvb, a(paramblvb));
  }
  
  public void a(List<blvb> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(blvb.jdField_a_of_type_Blvb);
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
      if (bluy.a() != null) {
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
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.jdField_a_of_type_Boolean));
        a(((blux)paramVarArgs[0]).a);
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
    blvb localblvb = (blvb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localblvb == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      if ((paramViewHolder instanceof blsu))
      {
        localObject = (blsu)paramViewHolder;
        if (localblvb.equals(bluy.a())) {
          ((blsu)localObject).a();
        } else {
          ((blsu)localObject).b();
        }
      }
      else if ((paramViewHolder instanceof blsv))
      {
        localObject = (blsv)paramViewHolder;
        if ((localblvb.equals(bluy.a())) && (localblvb.e))
        {
          ((blsv)localObject).a(2, localblvb);
        }
        else
        {
          localblvb.jdField_a_of_type_Boolean = false;
          ((blsv)localObject).a(1, localblvb);
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
    blvb localblvb = (blvb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    b(localblvb);
    if (localblvb.b) {
      localblvb.c = true;
    }
    for (;;)
    {
      a(localblvb, i);
      break;
      localblvb.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558502, paramViewGroup, false);
      paramViewGroup = new blsu(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558501, paramViewGroup, false);
      paramViewGroup = new blsv(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void onDownloadFinish(blvb paramblvb, boolean paramBoolean)
  {
    if (paramblvb == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = a(paramblvb);
      } while (i <= 0);
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, i, paramblvb, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void onProgressUpdate(blvb paramblvb, int paramInt)
  {
    paramInt = a(paramblvb);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsh
 * JD-Core Version:    0.7.0.1
 */