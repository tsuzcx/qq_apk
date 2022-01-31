class bmjc
  implements bmzq<Boolean, bmzv>
{
  bmjc(bmja parambmja) {}
  
  public Void a(Boolean paramBoolean, bmzv parambmzv)
  {
    if ((!paramBoolean.booleanValue()) || (parambmzv == null) || (parambmzv.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    wxe.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambmzv.jdField_a_of_type_Int));
    if (parambmzv.jdField_a_of_type_Int >= this.a.a.length)
    {
      wxe.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambmzv.jdField_a_of_type_Int) });
      return null;
    }
    wxe.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambmzv.jdField_a_of_type_Int));
    this.a.a[parambmzv.jdField_a_of_type_Int] = bmjd.a(this.a.a[parambmzv.jdField_a_of_type_Int], parambmzv.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambmzv.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambmzv.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjc
 * JD-Core Version:    0.7.0.1
 */