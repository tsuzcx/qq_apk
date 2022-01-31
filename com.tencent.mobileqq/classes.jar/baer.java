import android.text.SpannableString;

class baer
{
  public final int a;
  public final SpannableString a;
  
  public baer(int paramInt, SpannableString paramSpannableString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (baer)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString != null) {
        return this.jdField_a_of_type_AndroidTextSpannableString.equals(paramObject.jdField_a_of_type_AndroidTextSpannableString);
      }
    } while (paramObject.jdField_a_of_type_AndroidTextSpannableString == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_AndroidTextSpannableString != null) {}
    for (int i = this.jdField_a_of_type_AndroidTextSpannableString.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AtTag{");
    localStringBuilder.append("startIndex=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", atSpan=").append(this.jdField_a_of_type_AndroidTextSpannableString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baer
 * JD-Core Version:    0.7.0.1
 */