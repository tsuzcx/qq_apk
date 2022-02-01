import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
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
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class bnrr
  extends RecyclerView.Adapter<bnrx>
{
  private int jdField_a_of_type_Int;
  private LifecycleOwner jdField_a_of_type_AndroidArchLifecycleLifecycleOwner;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bnrw jdField_a_of_type_Bnrw;
  private bnts jdField_a_of_type_Bnts;
  private HashMap<String, SoftReference<bntn>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bnri> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public bnrr(Context paramContext, List<bnri> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bnri)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (bntn)((SoftReference)localObject1).get();; localObject1 = null)
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
        localObject1 = new bntn(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((bntn)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof bntn)))
        {
          ((bntn)paramImageView.getDrawable()).stop();
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
    if (this.jdField_a_of_type_Bnts != null)
    {
      this.jdField_a_of_type_Bnts.a().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new bnrt(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Bnts.b().observe(this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner, new bnru(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new bnrv(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anni.a(2131698772));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anni.a(2131698782));
  }
  
  public bnrx a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnrx(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558571, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bnrw parambnrw)
  {
    this.jdField_a_of_type_Bnrw = parambnrw;
  }
  
  public void a(bnrx parambnrx)
  {
    super.onViewRecycled(parambnrx);
    if ((bnrx.a(parambnrx) != null) && (bnrx.a(parambnrx).getDrawable() != null) && ((bnrx.a(parambnrx).getDrawable() instanceof bntn)))
    {
      ((bntn)bnrx.a(parambnrx).getDrawable()).stop();
      bnrx.a(parambnrx).setImageDrawable(null);
    }
  }
  
  public void a(bnrx parambnrx, int paramInt)
  {
    bnri localbnri = (bnri)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837947);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    bnrx.a(parambnrx).setImageDrawable((Drawable)localObject);
    bnrx.a(parambnrx).setVisibility(4);
    parambnrx.a(localbnri.a());
    switch (localbnri.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambnrx.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambnrx.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambnrx.itemView.setOnClickListener(new bnrs(this, localbnri, paramInt, parambnrx));
        EventCollector.getInstance().onRecyclerBindViewHolder(parambnrx, paramInt, getItemId(paramInt));
        return;
        bnrx.b(parambnrx).setVisibility(4);
        bnrx.a(parambnrx).setVisibility(0);
      }
    }
    bnrx.a(parambnrx).setVisibility(8);
    if (paramInt == 0)
    {
      a(bnrx.a(parambnrx));
      bnrx.a(parambnrx).setVisibility(0);
    }
    bnrx.b(parambnrx).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambnrx.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localbnri.c;
      a(bnrx.a(parambnrx), (String)localObject, paramInt);
      break;
      parambnrx.a(false);
    }
  }
  
  public void a(bnts parambnts, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Bnts = parambnts;
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleOwner = paramLifecycleOwner;
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
 * Qualified Name:     bnrr
 * JD-Core Version:    0.7.0.1
 */