import android.os.Bundle;
import androidx.annotation.NonNull;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.tencent.mobileqq.flutter.container.QFlutterFragment;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class auob
{
  private FlutterView.RenderMode jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$RenderMode = FlutterView.RenderMode.surface;
  private FlutterView.TransparencyMode jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$TransparencyMode = FlutterView.TransparencyMode.transparent;
  private FlutterShellArgs jdField_a_of_type_IoFlutterEmbeddingEngineFlutterShellArgs;
  private final Class<? extends QFlutterFragment> jdField_a_of_type_JavaLangClass = QFlutterFragment.class;
  private String jdField_a_of_type_JavaLangString = "";
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  
  @NonNull
  private Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterShellArgs != null) {
      localBundle.putStringArray("initialization_args", this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterShellArgs.toArray());
    }
    Object localObject = new BoostFlutterActivity.SerializableMap();
    ((BoostFlutterActivity.SerializableMap)localObject).setMap(this.jdField_a_of_type_JavaUtilMap);
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putSerializable("params", (Serializable)localObject);
    if (this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$RenderMode != null)
    {
      localObject = this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$RenderMode.name();
      localBundle.putString("flutterview_render_mode", (String)localObject);
      if (this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$TransparencyMode == null) {
        break label124;
      }
    }
    label124:
    for (localObject = this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView$TransparencyMode.name();; localObject = FlutterView.TransparencyMode.transparent.name())
    {
      localBundle.putString("flutterview_transparency_mode", (String)localObject);
      localBundle.putBoolean("destroy_engine_with_fragment", true);
      return localBundle;
      localObject = FlutterView.RenderMode.surface.name();
      break;
    }
  }
  
  public auob a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public auob a(@NonNull Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  @NonNull
  public <T extends QFlutterFragment> T a()
  {
    try
    {
      QFlutterFragment localQFlutterFragment = (QFlutterFragment)this.jdField_a_of_type_JavaLangClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localQFlutterFragment == null) {
        throw new RuntimeException("The NewFlutterFragment subclass sent in the constructor (" + this.jdField_a_of_type_JavaLangClass.getCanonicalName() + ") does not match the expected return type.");
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.jdField_a_of_type_JavaLangClass.getName() + ")", localException);
    }
    localException.setArguments(a());
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auob
 * JD-Core Version:    0.7.0.1
 */