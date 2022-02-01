package android.support.v4.app;

public abstract class QFragmentTransaction
{
  public static final int TRANSIT_ENTER_MASK = 4096;
  public static final int TRANSIT_EXIT_MASK = 8192;
  public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
  public static final int TRANSIT_FRAGMENT_FADE = 4099;
  public static final int TRANSIT_FRAGMENT_OPEN = 4097;
  public static final int TRANSIT_NONE = 0;
  public static final int TRANSIT_UNSET = -1;
  
  public abstract QFragmentTransaction add(int paramInt, QFragment paramQFragment);
  
  public abstract QFragmentTransaction add(int paramInt, QFragment paramQFragment, String paramString);
  
  public abstract QFragmentTransaction add(QFragment paramQFragment, String paramString);
  
  public abstract QFragmentTransaction addToBackStack(String paramString);
  
  public abstract QFragmentTransaction attach(QFragment paramQFragment);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract QFragmentTransaction detach(QFragment paramQFragment);
  
  public abstract QFragmentTransaction disallowAddToBackStack();
  
  public abstract QFragmentTransaction hide(QFragment paramQFragment);
  
  public abstract boolean isAddToBackStackAllowed();
  
  public abstract boolean isEmpty();
  
  public abstract QFragmentTransaction remove(QFragment paramQFragment);
  
  public abstract QFragmentTransaction replace(int paramInt, QFragment paramQFragment);
  
  public abstract QFragmentTransaction replace(int paramInt, QFragment paramQFragment, String paramString);
  
  public abstract QFragmentTransaction setBreadCrumbShortTitle(int paramInt);
  
  public abstract QFragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence);
  
  public abstract QFragmentTransaction setBreadCrumbTitle(int paramInt);
  
  public abstract QFragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence);
  
  public abstract QFragmentTransaction setCustomAnimations(int paramInt1, int paramInt2);
  
  public abstract QFragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract QFragmentTransaction setTransition(int paramInt);
  
  public abstract QFragmentTransaction setTransitionStyle(int paramInt);
  
  public abstract QFragmentTransaction show(QFragment paramQFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentTransaction
 * JD-Core Version:    0.7.0.1
 */