package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Scene
{
  private Context mContext;
  private Runnable mEnterAction;
  private Runnable mExitAction;
  private View mLayout;
  private int mLayoutId = -1;
  private ViewGroup mSceneRoot;
  
  public Scene(@NonNull ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
  }
  
  private Scene(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    this.mContext = paramContext;
    this.mSceneRoot = paramViewGroup;
    this.mLayoutId = paramInt;
  }
  
  public Scene(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    this.mSceneRoot = paramViewGroup;
    this.mLayout = paramView;
  }
  
  @Nullable
  public static Scene getCurrentScene(@NonNull ViewGroup paramViewGroup)
  {
    return (Scene)paramViewGroup.getTag(R.id.transition_current_scene);
  }
  
  @NonNull
  public static Scene getSceneForLayout(@NonNull ViewGroup paramViewGroup, @LayoutRes int paramInt, @NonNull Context paramContext)
  {
    Object localObject2 = (SparseArray)paramViewGroup.getTag(R.id.transition_scene_layoutid_cache);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SparseArray();
      paramViewGroup.setTag(R.id.transition_scene_layoutid_cache, localObject1);
    }
    localObject2 = (Scene)((SparseArray)localObject1).get(paramInt);
    if (localObject2 != null) {
      return localObject2;
    }
    paramViewGroup = new Scene(paramViewGroup, paramInt, paramContext);
    ((SparseArray)localObject1).put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  static void setCurrentScene(@NonNull ViewGroup paramViewGroup, @Nullable Scene paramScene)
  {
    paramViewGroup.setTag(R.id.transition_current_scene, paramScene);
  }
  
  public void enter()
  {
    if ((this.mLayoutId > 0) || (this.mLayout != null))
    {
      getSceneRoot().removeAllViews();
      if (this.mLayoutId > 0) {
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
      } else {
        this.mSceneRoot.addView(this.mLayout);
      }
    }
    Runnable localRunnable = this.mEnterAction;
    if (localRunnable != null) {
      localRunnable.run();
    }
    setCurrentScene(this.mSceneRoot, this);
  }
  
  public void exit()
  {
    if (getCurrentScene(this.mSceneRoot) == this)
    {
      Runnable localRunnable = this.mExitAction;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  @NonNull
  public ViewGroup getSceneRoot()
  {
    return this.mSceneRoot;
  }
  
  boolean isCreatedFromLayoutResource()
  {
    return this.mLayoutId > 0;
  }
  
  public void setEnterAction(@Nullable Runnable paramRunnable)
  {
    this.mEnterAction = paramRunnable;
  }
  
  public void setExitAction(@Nullable Runnable paramRunnable)
  {
    this.mExitAction = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Scene
 * JD-Core Version:    0.7.0.1
 */