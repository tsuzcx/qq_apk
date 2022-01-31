import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class blcj
  extends RecyclerView.Adapter<blcp>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private blco jdField_a_of_type_Blco;
  private blek jdField_a_of_type_Blek;
  private bmdn jdField_a_of_type_Bmdn;
  private HashMap<String, SoftReference<blef>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<blca> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public blcj(Context paramContext, List<blca> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((blca)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (blef)((SoftReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject2 = new File(paramString);
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2.length > 0)
            {
              int i = 0;
              while (i < localObject2.length)
              {
                String str = String.format(paramString + "/frame_%03d.png", new Object[] { Integer.valueOf(i) });
                if (new File(str).exists()) {
                  ((ArrayList)localObject1).add(str);
                }
                i += 1;
              }
            }
          }
        }
        localObject1 = new blef(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((blef)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof blef)))
        {
          ((blef)paramImageView.getDrawable()).stop();
          paramImageView.setImageDrawable(null);
        }
        paramImageView.setImageDrawable(paramString);
        paramString.start();
        return;
      }
    }
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    if (this.jdField_a_of_type_Blek != null)
    {
      this.jdField_a_of_type_Blek.a().a(this.jdField_a_of_type_Bmdn, new blcl(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Blek.b().a(this.jdField_a_of_type_Bmdn, new blcm(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new blcn(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(alud.a(2131700346));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(alud.a(2131700356));
  }
  
  public blcp a(ViewGroup paramViewGroup, int paramInt)
  {
    return new blcp(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558544, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(blco paramblco)
  {
    this.jdField_a_of_type_Blco = paramblco;
  }
  
  public void a(blcp paramblcp)
  {
    super.onViewRecycled(paramblcp);
    if ((blcp.a(paramblcp) != null) && (blcp.a(paramblcp).getDrawable() != null) && ((blcp.a(paramblcp).getDrawable() instanceof blef)))
    {
      ((blef)blcp.a(paramblcp).getDrawable()).stop();
      blcp.a(paramblcp).setImageDrawable(null);
    }
  }
  
  public void a(blcp paramblcp, int paramInt)
  {
    blca localblca = (blca)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837719);
    localObject = bduc.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    blcp.a(paramblcp).setImageDrawable((Drawable)localObject);
    blcp.a(paramblcp).setVisibility(4);
    paramblcp.a(localblca.a());
    switch (localblca.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = paramblcp.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        paramblcp.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramblcp.itemView.setOnClickListener(new blck(this, localblca, paramInt, paramblcp));
        return;
        blcp.b(paramblcp).setVisibility(4);
        blcp.a(paramblcp).setVisibility(0);
      }
    }
    blcp.a(paramblcp).setVisibility(8);
    if (paramInt == 0)
    {
      a(blcp.a(paramblcp));
      blcp.a(paramblcp).setVisibility(0);
    }
    blcp.b(paramblcp).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      paramblcp.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localblca.c;
      a(blcp.a(paramblcp), (String)localObject, paramInt);
      break;
      paramblcp.a(false);
    }
  }
  
  public void a(blek paramblek, bmdn parambmdn)
  {
    this.jdField_a_of_type_Blek = paramblek;
    this.jdField_a_of_type_Bmdn = parambmdn;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcj
 * JD-Core Version:    0.7.0.1
 */