import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;

public class blks
{
  public static ViewModelProvider a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    return new ViewModelProvider(paramViewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
  }
  
  public static ViewModelProvider a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, ViewModelProvider.Factory paramFactory)
  {
    return new ViewModelProvider(paramViewModelStoreOwner, paramFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blks
 * JD-Core Version:    0.7.0.1
 */